package com.leo.fly.db.message.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.message.entity.Message;
import com.leo.fly.db.message.params.MessageAddForm;
import com.leo.fly.db.message.params.MessageQueryForm;
import com.leo.fly.db.message.params.MessageQueryParam;
import com.leo.fly.db.message.params.MessageUpdateForm;
import com.leo.fly.db.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;
	@PostMapping
	public JsonResult add(@RequestBody MessageAddForm addForm) {
		//log.debug("name:{}", addForm);
		Message message = addForm.toPo(Message.class);
		return JsonResult.success(messageService.save(message));
	}
	@PutMapping()
	public JsonResult update( @Valid @RequestBody MessageUpdateForm updateForm) {
		Message message = updateForm.toPo(Message.class);
		return JsonResult.success(messageService.updateById(message));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		//log.debug("get with id:{}", id);
		return JsonResult.success(messageService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody MessageQueryForm messageQueryForm) {
		//log.debug("search with messageQueryForm:{}", messageQueryForm);
		Page<Message> page = messageService.page(messageQueryForm.getPage(), messageQueryForm.toParam(MessageQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(messageService.removeById(id));
	}
}
