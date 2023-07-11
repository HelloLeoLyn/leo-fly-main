package com.leo.fly.auto.code.controller;

import com.leo.fly.auto.code.components.DBTablesNameComponent;
import com.leo.fly.auto.code.params.TableParam;
import com.leo.fly.common.entity.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    DBTablesNameComponent dbTablesNameComponent;
    @PostMapping("/list")
    public JsonResult list(@RequestBody TableParam param) {
        return JsonResult.success(dbTablesNameComponent.list(param));
    }

    @PostMapping("/info")
    public JsonResult info(@RequestBody TableParam param) {
        return JsonResult.success(dbTablesNameComponent.info(param));
    }
}
