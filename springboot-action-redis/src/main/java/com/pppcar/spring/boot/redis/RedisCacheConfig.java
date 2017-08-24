package com.pppcar.spring.boot.redis;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching // 启用缓存，这个注解很重要；
public class RedisCacheConfig extends CachingConfigurerSupport {

	/**
	 * 缓存管理器.
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager  cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(1000L);
		return cacheManager;
	}

	/**
	 * redis模板操作类,类似于jdbcTemplate的一个类;
	 *
	 * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
	 *
	 * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
	 *
	 * 自己的缓存类，比如：RedisStorage类;
	 *
	 * @param factory
	 *            : 通过Spring进行注入，参数在application.properties进行配置；
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);

		// key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
		// 所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
		// 或者JdkSerializationRedisSerializer序列化方式;
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();// Long类型不可以会出现异常信息;
		redisTemplate.setKeySerializer(redisSerializer);
	/*	Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(com.fasterxml.jackson.annotation.PropertyAccessor.ALL, Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);*/
		return redisTemplate;
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				System.out.println("keyGenerator=" + sb.toString());
				return sb.toString();
			}
		};
	}

}