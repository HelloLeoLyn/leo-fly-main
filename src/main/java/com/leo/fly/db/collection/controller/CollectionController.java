package com.leo.fly.db.collection.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.collection.entity.Collection;
import com.leo.fly.db.collection.params.CollectionAddForm;
import com.leo.fly.db.collection.params.CollectionQueryForm;
import com.leo.fly.db.collection.params.CollectionUpdateForm;
import com.leo.fly.db.collection.params.CollectionQueryParam;
import com.leo.fly.db.collection.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/collection")
public class CollectionController {
	@Autowired
	CollectionService collectionService;
	@PostMapping
	public JsonResult add(@RequestBody CollectionAddForm addForm) {
		//log.debug("name:{}", addForm);
		Collection collection = addForm.toPo(Collection.class);
		return JsonResult.success(collectionService.save(collection));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody CollectionUpdateForm updateForm) {
		Collection collection = updateForm.toPo(Collection.class);
		return JsonResult.success(collectionService.updateById(collection));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(collectionService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody CollectionQueryForm collectionQueryForm) {
		//log.debug("search with collectionQueryForm:{}", collectionQueryForm);
		Page<Collection> page = collectionService.page(collectionQueryForm.getPage(), collectionQueryForm.toParam(CollectionQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(collectionService.removeById(id));
	}
}
