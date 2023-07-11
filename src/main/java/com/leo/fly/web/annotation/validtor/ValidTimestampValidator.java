package com.leo.fly.web.annotation.validtor;

import com.leo.fly.web.annotation.ValidTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
　 * <p>Title: ValidTimestampValidator.java</p> 
　 * <p>Description: 校验请求时间时限</p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年2月18日 
　 * @version 1.0
 */
public class ValidTimestampValidator implements ConstraintValidator<ValidTimestamp, String>{
	@Value("${spring.profiles.active}")
	private String env;
	
	private long minus;
	private long plus;
	
	@Override
	public void initialize(ValidTimestamp constraintAnnotation) {
		plus = constraintAnnotation.plus();;
		minus = constraintAnnotation.minus();		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if ( value == null ) {
			return true;
		}
		return true;
	}
}
