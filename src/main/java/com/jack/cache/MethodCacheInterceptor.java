package com.jack.cache;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class MethodCacheInterceptor implements MethodInterceptor{

	
	private RedisTemplate<Serializable, Object> redisTemplate;
	private Long defaultCacheExpireTime = 100l; // 缓存默认的过期时间,这里设置了10秒
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object value = null;
		String targetName = invocation.getThis().getClass().getName();
		String method = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		
		String key = getCacheKey(targetName, method, arguments);
		try{
			if(exists(key)){
				return getCache(key);
			}
			
			value = invocation.proceed();
			if(value != null){
				final String tKey= key;
				final Object tValue = value;
				
				new Thread(new Runnable(){
	
					public void run() {
						setCache(tKey, tValue, defaultCacheExpireTime);	
					}
					
				}).start();
				
			}
		}catch(Exception e){
			if(value == null){
				return invocation.proceed();
			}
		
		}
		return value;
	}

	protected void setCache(String tKey, Object tValue, Long defaultCacheExpireTime) {
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		operations.set(tKey, tValue);
		redisTemplate.expire(tKey, defaultCacheExpireTime, TimeUnit.SECONDS);
		
	}

	private Object getCache(String key) {
		ValueOperations<Serializable, Object> operation = redisTemplate.opsForValue();
		Object value = operation.get(key);
		return value;
	}

	private boolean exists(String key) {
		System.out.println("key: " + key);
		Boolean hasKey = redisTemplate.hasKey(key);
		
		return hasKey;
	}

	private String getCacheKey(String targetName, String method, Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append("_").append(method);
		if(arguments != null && arguments.length > 0){
			for (int i = 0; i < arguments.length; i++) {
				sb.append("_").append(arguments[i]);
			}
		}
		
		return sb.toString();
	}

	public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
