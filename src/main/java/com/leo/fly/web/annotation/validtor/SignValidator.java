package com.leo.fly.web.annotation.validtor;

import com.leo.fly.common.util.MD5Util;
import com.leo.fly.web.annotation.Sign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * 
　 * <p>Title: SignValidator.java</p> 
　 * <p>Description: </p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年2月18日 
　 * @version 1.0
 */
public class SignValidator implements ConstraintValidator<Sign, Object>{
	private static Logger log = LoggerFactory.getLogger(SignValidator.class);
	private String[] signFields;
	private String signField;
	@Value("${session.active: true}")
	private boolean doIt;
	@Override
	public void initialize(Sign sign) {
		signFields = sign.signFields();
		signField = sign.signField();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if ( value == null ) {
			return true;
		}
		if ( !doIt ) {
			return true;
		}
		try {
			return impl(value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			log.error("requestUri:{} error:{}",null,e.getMessage());
			return false;
		}
	}
	
	private boolean impl(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<? extends Object> classz = obj.getClass();
		StringBuilder sb = new StringBuilder();
		for(String fieldName : signFields) {
			Field f = classz.getDeclaredField(fieldName);
			f.setAccessible(true);
			sb.append(f.get(obj));
		}
		String words = MD5Util.string2MD5(sb.toString());
		Field f = classz.getDeclaredField(signField);
		f.setAccessible(true);
		Object object = f.get(obj);
		if(words.equals(object)) {
			return true;
		};
		return false;
	}
}
