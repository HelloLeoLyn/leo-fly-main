package com.leo.fly.sys.controller;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.components.EncodePasswordComponent;
import com.leo.fly.sys.entity.SysUser;
import com.leo.fly.sys.param.SysUserForm;
import com.leo.fly.sys.param.SysUserQueryForm;
import com.leo.fly.sys.param.SysUserQueryParam;
import com.leo.fly.sys.service.SysUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sys/user")
@Api("user")
@Slf4j
public class SysUserController {

	@Autowired
	private SysUserService userService;
	@Autowired
	EncodePasswordComponent encodePasswordComponent;
	@ApiOperation(value = "新增用户", notes = "新增一个用户")
	@ApiImplicitParam(name = "userForm", value = "新增用户form表单", required = true, dataType = "UserForm")
	@PostMapping
	public JsonResult add(@Valid @RequestBody SysUserForm userForm) {
		log.debug("name:{}", userForm);
		SysUser user = userForm.toPo(SysUser.class);
		user.setPassword(encodePasswordComponent.encode("MD5",userForm.getPassword()));
		userService.save(user);
		return JsonResult.success(user);
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象，逻辑删除")
	@ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "string")
	@DeleteMapping(value = "/{id}")
	public JsonResult delete(@PathVariable String id) {
		return JsonResult.success(userService.removeById(id));
	}

	@ApiOperation(value = "修改用户", notes = "修改指定用户信息")
	@ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "string"),
			@ApiImplicitParam(name = "userUpdateForm", value = "用户实体", required = true, dataType = "UserUpdateForm")})
	@PutMapping()
	public JsonResult update( @Valid @RequestBody SysUserForm userForm) {
		SysUser user = userForm.toPo(SysUser.class);
		return JsonResult.success(userService.updateById(user));
	}

	@ApiOperation(value = "获取用户", notes = "获取指定用户信息")
	@ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "string")
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		log.debug("get with id:{}", id);
		return JsonResult.success(userService.getById(id));
	}

	@ApiOperation(value = "搜索用户", notes = "根据条件查询用户信息")
	@ApiImplicitParam(name = "userQueryForm", value = "用户查询参数", required = true, dataType = "UserQueryForm")
	@ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = JsonResult.class))
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody SysUserQueryForm userQueryForm) {
		log.debug("search with userQueryForm:{}", userQueryForm);
		return JsonResult.success(userService.query(userQueryForm.getPage(), userQueryForm.toParam(SysUserQueryParam.class)));
	}
}

