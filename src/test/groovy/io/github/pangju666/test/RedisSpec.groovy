package io.github.pangju666.test

import io.github.pangju666.framework.data.redis.bean.JavaScanRedisTemplate
import io.github.pangju666.framework.data.redis.bean.JsonScanRedisTemplate
import io.github.pangju666.framework.data.redis.bean.StringScanRedisTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class RedisSpec extends Specification {
	@Autowired
	StringScanRedisTemplate stringScanRedisTemplate
	@Autowired
	JavaScanRedisTemplate javaScanRedisTemplate
	@Autowired
	JsonScanRedisTemplate jsonScanRedisTemplate

	def "scanKeys"() {
		setup:
		println stringScanRedisTemplate.scanKeys()
	}

	def "scanSetValues"() {
		setup:
		println stringScanRedisTemplate.scanSetValues("test_set")
	}

	def "scanZSetValues"() {
		setup:
		println stringScanRedisTemplate.scanZSetValues("test_zset")
	}

	def "scanHashValues"() {
		setup:
		println stringScanRedisTemplate.scanHashValues("test_hash")
	}
}
