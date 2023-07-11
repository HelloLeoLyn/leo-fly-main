package com.leo.fly.ailibaba.order;


import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.web.form.BaseQueryForm;
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
 * @since 2021-01-21
 */
@RestController
@RequestMapping("/order/1688")
public class Order1688Controller {

    @Autowired
    Order1688Service order1688Service;
    @PostMapping("/list")
    public JsonResult list(@Valid @RequestBody BaseQueryForm form){
        return JsonResult.success(order1688Service.list(form));
    }

}


