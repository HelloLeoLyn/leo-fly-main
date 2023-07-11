package com.leo.fly.web.handler;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.service.BaseErrorEnum;
import com.leo.fly.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.List;

@Slf4j
@ControllerAdvice
public class WebExceptionHandler {

    @Value("${error-alert-i18: false}")
    private boolean errorI18;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult comHandler(Exception e, HttpServletRequest request) {
//        String transCode = StringUtils.defaultIfBlank(UserContextHolder.getInstance().getTransCode(),"");
        String transCode = "";
        if (e instanceof NoHandlerFoundException) {
            return JsonResult.fail(ErrorCodeEnum.E_404);
        } else if (e instanceof ValidationException) {
            log.error(e.getMessage());
            return JsonResult.fail(remark(ErrorCodeEnum.E_VALIDATION), "", e.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException a = (MethodArgumentNotValidException) e;
            BindingResult result = a.getBindingResult();
            List<ObjectError> allErrors = result.getAllErrors();
            log.error("transCode:{},message:{},errorCode:{}", transCode,  e.getMessage(),ErrorCodeEnum.E_METHOD_ARGUMENT_NOT_VALID.getCode());
            if ("Session".equals(allErrors.get(0).getDefaultMessage())) {
                return JsonResult.fail(ErrorCodeEnum.E_LOGIN);
            }
            return JsonResult.fail(ErrorCodeEnum.E_METHOD_ARGUMENT_NOT_VALID.getCode(), null,
                    allErrors.get(0).getDefaultMessage());
        } else if (e instanceof ComException) {
            ComException comException = (ComException) e;
            if(StringUtils.equals(comException.getBaseErrorEnum().getCode(), ErrorCodeEnum.E_USER_NOT_FOUND.getCode())||comException.getBaseErrorEnum() == ErrorCodeEnum.E_USER_EXISTS){
                log.error("transCode:{},message:{},errorCode:{}", transCode,comException.getMessage(),comException.getBaseErrorEnum().getCode());
            }else{
                log.error("transCode:{},message:{},errorCode:{}", transCode,comException.getMessage(),comException.getBaseErrorEnum().getCode());
                log.error("exception", e);
            }
            return JsonResult.fail(comException);
        } else {
            log.error("transCode:{},message:{}", transCode,e.getMessage());
            log.error("exception", e);
            return JsonResult.fail("000001", "", e.getMessage() == null ? e.getClass().getName() : e.getMessage());
        }
    }
    private String remark(BaseErrorEnum errorEnum){
        if(errorI18){
            return errorEnum.getI18Remark();
        }
        return errorEnum.getRemark();
    }
}
