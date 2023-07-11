package com.leo.fly.db.work.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.work.entity.Work;
import com.leo.fly.db.work.params.WorkAddForm;
import com.leo.fly.db.work.params.WorkQueryForm;
import com.leo.fly.db.work.params.WorkQueryParam;
import com.leo.fly.db.work.params.WorkUpdateForm;
import com.leo.fly.db.work.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/work")
public class WorkController {
	@Autowired
	WorkService workService;
	@PostMapping
	public JsonResult add(@RequestBody WorkAddForm addForm) {
		//log.debug("name:{}", addForm);
		Work work = addForm.toPo(Work.class);
		return JsonResult.success(workService.save(work));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody WorkUpdateForm updateForm) {
		Work work = updateForm.toPo(Work.class);
		return JsonResult.success(workService.updateById(work));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(workService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody WorkQueryForm workQueryForm) {
//		log.debug("search with workQueryForm:{}", workQueryForm);
		Page<Work> page = workService.page(workQueryForm.getPage(), workQueryForm.toParam(WorkQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(workService.removeById(id));
	}

	@GetMapping(value = "/date/{date}")
	public JsonResult date(@PathVariable String date) {
		LambdaQueryWrapper<Work> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.le(Work::getStart, date);
		queryWrapper.ge(Work::getEnd, date);
		return JsonResult.success(workService.list(queryWrapper));
	}
}
