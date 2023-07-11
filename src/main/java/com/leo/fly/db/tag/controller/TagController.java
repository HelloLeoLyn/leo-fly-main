package com.leo.fly.db.tag.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.tag.entity.Tag;
import com.leo.fly.db.tag.params.TagAddForm;
import com.leo.fly.db.tag.params.TagQueryForm;
import com.leo.fly.db.tag.params.TagUpdateForm;
import com.leo.fly.db.tag.params.TagQueryParam;
import com.leo.fly.db.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	TagService tagService;
	@PostMapping
	public JsonResult add(@RequestBody TagAddForm addForm) {
		//log.debug("name:{}", addForm);
		Tag tag = addForm.toPo(Tag.class);
		return JsonResult.success(tagService.save(tag));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody TagUpdateForm updateForm) {
		Tag tag = updateForm.toPo(Tag.class);
		return JsonResult.success(tagService.updateById(tag));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(tagService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody TagQueryForm tagQueryForm) {
		//log.debug("search with tagQueryForm:{}", tagQueryForm);
		Page<Tag> page = tagService.page(tagQueryForm.getPage(), tagQueryForm.toParam(TagQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(tagService.removeById(id));
	}
}
