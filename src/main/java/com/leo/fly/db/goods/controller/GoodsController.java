package com.leo.fly.db.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.db.goods.params.*;
import com.leo.fly.db.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;
	@PostMapping
	public JsonResult add(@RequestBody GoodsAddForm addForm) {
		//log.debug("name:{}", addForm);
		Goods goods = addForm.toPo(Goods.class);
		return JsonResult.success(goodsService.save(goods));
	}

	@PostMapping(value="/batch")
	public JsonResult saveBatch(@RequestBody List<Goods> goodsList) {
		//log.debug("name:{}", addForm);
		return JsonResult.success(goodsService.saveBatch(goodsList));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody Goods goods) {
		return JsonResult.success(goodsService.updateById(goods));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(goodsService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody GoodsQueryForm goodsQueryForm) {
		//log.debug("search with goodsQueryForm:{}", goodsQueryForm);
		Page<Goods> page = goodsService.page(goodsQueryForm.getPage(), goodsQueryForm.toParam(GoodsQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(goodsService.removeById(id));
	}

	@PostMapping(value="/templates")
	public JsonResult templates(@RequestBody GoodsTemplateParams params){
		return JsonResult.success(goodsService.templates(params));
	}
}
