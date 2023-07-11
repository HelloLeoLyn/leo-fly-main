package com.leo.fly.ailibaba.access;


import com.leo.fly.common.entity.vo.JsonResult;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 1688采购订单详情对接
 *
 * @author Administrator
 * @create 2018 04 20
 */
@Controller
public class AccessController {




    @Autowired
    private AccessService accessService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取code
     * @return
     */
    @GetMapping(value = "/1688/auth")
    @ResponseBody
    public JsonResult userAuthorization() {
        return JsonResult.success(accessService.auth());
    }

    /**
     * 对获得的code进行处理
     * @param request
     * @return
     */
    @SneakyThrows
    @GetMapping(value = "/1688/access")
    public String authCode(HttpServletRequest request) {
        String code = request.getParameter("code");
        accessService.getAccess(code);
        String state = request.getParameter("state");
        if (state.equals("")){
            logger.info("Redirect path is null,can't jump!");
            return null;
        }
        return "redirect:http://localhost:9527/#/access/success";
    }

}