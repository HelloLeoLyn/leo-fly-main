package com.leo.fly.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.entity.SysDept;
import com.leo.fly.sys.param.SysDeptAddForm;
import com.leo.fly.sys.param.SysDeptQueryForm;
import com.leo.fly.sys.param.SysDeptUpdateForm;
import com.leo.fly.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 机构管理 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/sys/dept")
//@Access
public class SysDeptController {
    @Autowired
    SysDeptService sysDeptService;

    @PostMapping("/page")
    public JsonResult page(@RequestBody SysDeptQueryForm queryForm){
        Page page = queryForm.getPage();
        QueryWrapper<SysDept> query = new QueryWrapper<>();
        query.lambda().eq(queryForm.getDelFlag()!=null,SysDept::getDelFlag,queryForm.getDelFlag());
        return JsonResult.success(sysDeptService.page(page,query));
    }
    @PostMapping("/list")
    public JsonResult list(@RequestBody SysDeptQueryForm queryForm){
        QueryWrapper<SysDept> query = new QueryWrapper<>();
        query.lambda().eq(queryForm.getDelFlag()!=null,SysDept::getDelFlag,queryForm.getDelFlag());
        return JsonResult.success(sysDeptService.list(query));
    }
    @PostMapping()
    public JsonResult add(@RequestBody SysDeptAddForm addForm){
        return JsonResult.success(sysDeptService.save(addForm.toPo(SysDept.class)));
    }

    @PutMapping()
    public JsonResult put(@RequestBody SysDeptUpdateForm updateForm){
        return JsonResult.success(sysDeptService.updateById(updateForm.toPo(SysDept.class)));
    }

    @DeleteMapping("/{id}")
    public JsonResult deleteLogical(@PathVariable Long id){
        return JsonResult.success(sysDeptService.deleteLogical(id));
    }
}

