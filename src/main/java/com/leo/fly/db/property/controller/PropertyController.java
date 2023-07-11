package com.leo.fly.db.property.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.property.entity.Property;
import com.leo.fly.db.property.params.PropertyAddForm;
import com.leo.fly.db.property.params.PropertyQueryForm;
import com.leo.fly.db.property.params.PropertyUpdateForm;
import com.leo.fly.db.property.params.PropertyQueryParam;
import com.leo.fly.db.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {
	@Autowired
	PropertyService propertyService;
	@PostMapping
	public JsonResult add(@RequestBody PropertyAddForm addForm) {
		//log.debug("name:{}", addForm);
		Property property = addForm.toPo(Property.class);
		return JsonResult.success(propertyService.save(property));
	}
	@PostMapping("/save")
	public JsonResult save( @Valid @RequestBody PropertyAddForm saveForm) {
		Property property = saveForm.toPo(Property.class);
		try{
            return JsonResult.success(propertyService.save(property));
        }catch (Exception e){
            return JsonResult.success(propertyService.updateById(property));
        }
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody PropertyUpdateForm updateForm) {
		Property property = updateForm.toPo(Property.class);
		return JsonResult.success(propertyService.updateById(property));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(propertyService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody PropertyQueryForm propertyQueryForm) {
		//log.debug("search with propertyQueryForm:{}", propertyQueryForm);
		Page<Property> page = propertyService.page(propertyQueryForm.getPage(), propertyQueryForm.toParam(PropertyQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(propertyService.removeById(id));
	}
}
