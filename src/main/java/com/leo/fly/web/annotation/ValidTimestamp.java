package com.leo.fly.web.annotation;

import com.leo.fly.web.annotation.validtor.ValidTimestampValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 
　 * <p>Title: ValidTimestamp.java</p> 
　 * <p>Description:校验请求时间时限 </p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年2月18日 
　 * @version 1.0
 */
@Documented
@Constraint(validatedBy = ValidTimestampValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ValidTimestamp {
	long minus();
	
	long plus() default 0;
	String message() default "{com.leo.fly.admin.annotation.ValidTime.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	
}


