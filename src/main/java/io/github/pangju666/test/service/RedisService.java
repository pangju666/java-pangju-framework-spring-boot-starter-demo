package io.github.pangju666.test.service;

import io.github.pangju666.framework.data.redis.core.ScanRedisTemplate;
import io.github.pangju666.framework.data.redis.core.StringScanRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	private final ScanRedisTemplate<Object> redisTemplate;

	public RedisService(ScanRedisTemplate<Object> redisTemplate,
						StringScanRedisTemplate stringScanRedisTemplate,
						//@Qualifier("test1RedisTemplate")
						RedisTemplate<Object, Object> redisTemplate1,
						//@Qualifier("test2RedisTemplate")
						RedisTemplate<Object, Object> redisTemplate2) {
		this.redisTemplate = redisTemplate;
	}
}
