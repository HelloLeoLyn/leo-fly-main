package com.leo.fly.common.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.service.BaseErrorEnum;
import com.leo.fly.common.util.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: JsonResult
 * @Description:TODO(返回结果通用处理类json)
 * @author: 林义雄
 * @date: 2018年12月15日 下午3:23:59
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -5812914249561985113L;

    private static final String successCode = "200";
    private static final String successMsg = "success";

    @ApiModelProperty(value="状态码")
    private String code;

    @ApiModelProperty(value="业务数据")
    private T data;

    @ApiModelProperty(value="描述")
    private String msg;


    public static JsonResult success(Object data) {
        return new JsonResult(successCode, data, successMsg);
    }

    public static JsonResult success() {
        return new JsonResult(successCode, null, successMsg);
    }

    public static JsonResult fail(String code, Object obj, String msg) {
        return new JsonResult(code, obj, msg);
    }

    public static JsonResult fail(BaseErrorEnum baseErrorEnum) {
        return new JsonResult(baseErrorEnum.getCode(), null, baseErrorEnum.getI18Remark());
    }

    public static JsonResult fail(ComException exception) {
        return new JsonResult(exception.getBaseErrorEnum().getCode(), null, StringUtils.isBlank(exception.getMessage()) ? exception.getBaseErrorEnum().getI18Remark() : exception.getMessage());
    }

    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return successCode.equals(this.code);
    }
}

