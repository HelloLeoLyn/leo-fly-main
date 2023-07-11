package com.leo.fly.web.form;

import com.leo.fly.web.param.BaseParam;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @Description:    TODO(前端请求头信息公共类)   
 * @author: 林义雄  
 * @date:   2019年2月12日 上午11:26:07
 */
@Data
public class PublicBaseForm <P extends BasePo,R extends BaseParam>{

	@Valid
	@NotNull(message = "请求头参数不正确")
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

}
