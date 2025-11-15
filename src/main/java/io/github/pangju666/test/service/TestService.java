package io.github.pangju666.test.service;

import io.github.pangju666.test.model.entity.TestDO;
import io.github.pangju666.test.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
	//@Autowired(required = false)
	private TestRepository testRepository;
	/*private RedisTemplate<Object, Object> test1RedisTemplate;
	private RedisTemplate<Object, Object> test2RedisTemplate;
	private StringRedisTemplate stringRedisTemplate;
	private RedisTemplate<Object, Object> redisTemplate;*/

	public TestService(/*@Autowired(required = false) TestRepository testRepository,*/
					  /* @Qualifier("testRedisTemplate")
					   RedisTemplate<Object, Object> test1RedisTemplate,
					   @Qualifier("test2RedisTemplate")
					   RedisTemplate<Object, Object> test2RedisTemplate,
					   StringRedisTemplate stringRedisTemplate,
					   RedisTemplate<Object, Object> redisTemplate*/) {
		//this.testRepository = testRepository;
		/*this.test1RedisTemplate = test1RedisTemplate;
		this.test2RedisTemplate = test2RedisTemplate;
		this.stringRedisTemplate = stringRedisTemplate;
		this.redisTemplate = redisTemplate;*/
	}

	public List<TestDO> list() {
		return testRepository.list();
	}

	public String getRedisValue(String key1, String key2) {
		return "";
	}
}
