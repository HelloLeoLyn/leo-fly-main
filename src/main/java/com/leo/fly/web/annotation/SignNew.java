package com.leo.fly.web.annotation;

import com.leo.fly.common.enums.EncryptionEnum;
import com.leo.fly.web.annotation.validtor.SignNewValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = SignNewValidator.class)
@Target({ METHOD, FIELD })
@Retention(RUNTIME)

/**
 * 
　 * <p>Title: Sign.java</p> 
　 * <p>Description: </p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年2月18日 
　 * @version 1.0
 */
public @interface SignNew {
	String[] signFields();
	
	String signField();
	
	EncryptionEnum encType() default EncryptionEnum.MD5;
	
	String message() default "{com.leo.fly.admin.annotation.Sign.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	
}


