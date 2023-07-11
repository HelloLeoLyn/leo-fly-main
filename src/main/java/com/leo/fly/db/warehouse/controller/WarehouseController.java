package com.leo.fly.db.warehouse.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.db.warehouse.entity.Warehouse;
import com.leo.fly.db.warehouse.params.WarehouseAddForm;
import com.leo.fly.db.warehouse.params.WarehouseQueryForm;
import com.leo.fly.db.warehouse.params.WarehouseUpdateForm;
import com.leo.fly.db.warehouse.params.WarehouseQueryParam;
import com.leo.fly.db.warehouse.service.WarehouseService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	ProductAttributesService attributesService;
	@Autowired
	ProductService productService;
	@PostMapping
	public JsonResult add(@RequestBody WarehouseAddForm addForm) {
		//log.debug("name:{}", addForm);
		Warehouse warehouse = addForm.toPo(Warehouse.class);
		return JsonResult.success(warehouseService.save(warehouse));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody WarehouseUpdateForm updateForm) {
		Warehouse warehouse = updateForm.toPo(Warehouse.class);
		return JsonResult.success(warehouseService.updateById(warehouse));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(warehouseService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody WarehouseQueryForm warehouseQueryForm) {
		//log.debug("search with warehouseQueryForm:{}", warehouseQueryForm);
		Page<Warehouse> page = warehouseService.page(warehouseQueryForm.getPage(), warehouseQueryForm.toParam(WarehouseQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(warehouseService.removeById(id));
	}

	@PutMapping(value = "/syncProduct")
	public void syncProduct() throws IOException {
		File file = new File("C:\\Users\\Leo\\Downloads","excel-list.txt");
		List<String> lines = FileUtils.readLines(file, "UTF8");
		for (int i=1;i<lines.size();i++) {
			String line = lines.get(i);
			String[] split = line.split("\t");
			String id = split[0].replace("\u0000","");
			String code = split[1].replace(" ","").replace("\u0000","");
			String type = split[2].replace("\u0000","");
			List<ProductAttributes> list = attributesService.findByValue(code);
			Long productId;
			if(ObjectUtils.isNotEmpty(list)){
				productId = list.get(0).getProductId();
			}else {
				continue;
			}
			Warehouse warehouse = new Warehouse();
			warehouse.setId(Long.parseLong(id));
			warehouse.setProductId(productId);
			warehouse.setCodeType(type);
			Product product = productService.getById(productId);
			JSONObject json = product.getType();
			json.put(type,productId);
			product.setType(json);
			warehouseService.updateById(warehouse);
			productService.updateById(product);
		}
	}
}
