package com.leo.fly.web.annotation;


import com.leo.fly.web.annotation.validtor.SessionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 
　 * <p>Title: Session.java</p> 
　 * <p>Description:校验用户登录态 </p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年2月18日 
　 * @version 1.0
 */
@Documented
@Constraint(validatedBy = SessionValidator.class)
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface Session {
	String env() default "prod";
	boolean activeExpire() default false;
	
	long expire() default 0;
	
	String message() default "Session";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
