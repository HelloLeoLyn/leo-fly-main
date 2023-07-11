package com.leo.fly.db.message.mail;


import com.leo.fly.common.entity.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;
    @PostMapping("/website")
    public JsonResult website(@Valid @RequestBody MailForm form){
        mailService.transferOnWebsite(form);
        return JsonResult.success();
    }
}

