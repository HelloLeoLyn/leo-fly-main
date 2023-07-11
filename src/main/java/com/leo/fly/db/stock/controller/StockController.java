package com.leo.fly.db.stock.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.stock.entity.Stock;
import com.leo.fly.db.stock.params.StockAddForm;
import com.leo.fly.db.stock.params.StockQueryForm;
import com.leo.fly.db.stock.params.StockUpdateForm;
import com.leo.fly.db.stock.params.StockQueryParam;
import com.leo.fly.db.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService stockService;
	@PostMapping
	public JsonResult add(@RequestBody StockAddForm addForm) {
		//log.debug("name:{}", addForm);
		Stock stock = addForm.toPo(Stock.class);
		return JsonResult.success(stockService.save(stock));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody StockUpdateForm updateForm) {
		Stock stock = updateForm.toPo(Stock.class);
		return JsonResult.success(stockService.updateById(stock));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(stockService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody StockQueryForm stockQueryForm) {
		//log.debug("search with stockQueryForm:{}", stockQueryForm);
		Page<Stock> page = stockService.page(stockQueryForm.getPage(), stockQueryForm.toParam(StockQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(stockService.removeById(id));
	}
}
