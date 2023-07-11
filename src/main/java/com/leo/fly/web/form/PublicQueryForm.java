package com.leo.fly.web.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.web.param.BaseParam;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @Description:    TODO(前端请求头信息公共类)   
 * @author: 林义雄  
 * @date:   2019年2月12日 上午11:26:07
 */
@Slf4j
@Data
public class PublicQueryForm<P extends BasePo,R extends BaseParam>{
	/**
	 * 分页查询的参数，当前页数
	 */
	private Long current = 1l;
	/**
	 * 分页查询的参数，当前页面每页显示的数量
	 */
	private Long size = 10l;

	@Valid
	@NotNull(message = "请求头参数不正确")
//	@Sign(message = "解签失败！",signFields = { "appId","platform","timestamp","sessionId" }, signField = "sign")
//	@ApiModelProperty(value = "公共请求头，不能为空")
	private PublicRequestHeader header;

	public R toParam(Class<R> clazz) {

		R t = BeanUtils.instantiateClass(clazz);
		BeanUtils.copyProperties(this, t);
		return t;
	}

	public P toPo(Class<P> clazz) {
		P t = BeanUtils.instantiateClass(clazz);
		BeanUtils.copyProperties(this, t);
		return t;
	}

	/**
	 * 从form中获取page参数，用于分页查询参数
	 *
	 * @return
	 */
	public Page getPage() {
		return new Page(this.getCurrent(), this.getSize());
	}
}
