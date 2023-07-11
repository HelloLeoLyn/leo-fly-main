package com.leo.fly.web.annotation;


import java.lang.annotation.*;

/**
 * 
　 * <p>Title: Session.java</p> 
　 * <p>Description:非鉴权api </p>
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年2月18日 
　 * @version 1.0
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Access {
}
