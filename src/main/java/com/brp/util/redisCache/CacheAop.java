package com.brp.util.redisCache;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.brp.util.JedisUtils;

/**
 * Created by Administrator on 2016/5/5.
 */
@Component
@Aspect
public class CacheAop {

	@Resource
	private JedisUtils jedisUtils;

	@Pointcut("execution(* cloud.aps.service..*(..))")
	public void redisCached() {
	}

	@Around("redisCached()&&@annotation(cache)")
	public Object cached(final ProceedingJoinPoint pjp, RedisCache cache) throws Throwable {

		String parm = getCacheKey(pjp);
		String key = cache.key() + parm;
		Object value = jedisUtils.getObject(key);
		if (value != null)
			return value; // 如果缓存存在直接从缓存里面返回

		value = pjp.proceed();// 放行，调用业务类方法
		if (null == value) {
			return null;
		}
		if (cache.expire() <= 0) {
			jedisUtils.setObject(key, value, 0);
		} else {
			jedisUtils.setObject(key, value, cache.expire());
		}
		return value;
	}

	private String getCacheKey(ProceedingJoinPoint pjp) {
		StringBuilder buf = new StringBuilder();
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			buf.append(arg.toString());
		}
		return buf.toString();
	}

}
