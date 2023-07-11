package com.leo.fly.web.annotation.validtor;

import com.leo.fly.common.util.StringUtils;
import com.leo.fly.web.annotation.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.concurrent.TimeUnit;

/**
 * 
　 * <p>Title: SessionValidator.java</p> 
　 * <p>Description: </p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2020年6月10日 
　 * @version 1.0
 */
public class SessionValidator implements ConstraintValidator<Session, String>{
	@Autowired
	StringRedisTemplate redisTemplate;

	private long expire;
	private boolean activeExpire;
	private String env;

	@Value("${spring.profiles.active}")
	private String currentEnv;
	@Override
	public void initialize(Session session) {
		expire = session.expire();
		//暂时写死
		activeExpire = false;
		env = session.env();
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!StringUtils.equals(env, currentEnv)) {
			return true;
		}
		if(value==null) {
			return false;
		}
		String session = redisTemplate.boundValueOps(value).get();
		if(!StringUtils.isBlank(session)) {
			if(activeExpire) {
				redisTemplate.opsForValue().set(value, session, expire, TimeUnit.MINUTES);
			}
			return true;
		}else {
			return false;
		}
	}

}
