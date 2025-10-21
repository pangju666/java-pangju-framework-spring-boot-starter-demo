package io.github.pangju666.test

import io.github.pangju666.framework.data.redis.bean.ScanRedisTemplate
import io.github.pangju666.test.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class DynamicRedisSpec extends Specification {
	@Autowired
	TestService testService
	@Autowired
	ScanRedisTemplate<Object, Object> testRedisTemplate
	/*@Qualifier("redis-test-template")
	@Autowired
	RedisTemplate<Object, Object> testRedisTemplate
	@Qualifier("redis-test1-template")
	@Autowired
	RedisTemplate<Object, Object> test1RedisTemplate*/
	/*@Autowired
	private WebApplicationContext context

	MockMvc mockMvc

	def setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
	}*/

	def "test"() {
		setup:
		println testRedisTemplate.opsForValue().get("sadad")
		//println testService.getRedisValue("sadad", "asdadadadad")
	}
}
