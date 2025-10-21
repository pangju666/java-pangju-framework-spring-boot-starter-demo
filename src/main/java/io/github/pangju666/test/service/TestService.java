package io.github.pangju666.test.service;

import io.github.pangju666.test.model.entity.TestDO;
import io.github.pangju666.test.repository.TestRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
	private final TestRepository testRepository;
	private RedisTemplate<Object, Object> testRedisTemplate;
	private RedisTemplate<Object, Object> test1RedisTemplate;

	public TestService(TestRepository testRepository,
					   //@Qualifier("testRedisTemplate")
					   RedisTemplate<Object, Object> testRedisTemplate//,
					   //@Qualifier("test2RedisTemplate")
					   /*RedisTemplate<Object, Object> test1RedisTemplate*/) {
		this.testRepository = testRepository;
		this.testRedisTemplate = testRedisTemplate;
		this.test1RedisTemplate = testRedisTemplate;
	}

	public List<TestDO> list() {
		return testRepository.list();
	}

	public String getRedisValue(String key1, String key2) {
		return testRedisTemplate.opsForValue().get(key1) + "," + test1RedisTemplate.opsForValue().get(key2);
	}
}
