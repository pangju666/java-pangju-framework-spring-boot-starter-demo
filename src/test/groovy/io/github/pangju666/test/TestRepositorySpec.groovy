package io.github.pangju666.test

import io.github.pangju666.test.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class TestRepositorySpec extends Specification {
	@Autowired
	TestRepository repository

	def "测试"() {
		setup:
		repository.removeById(1L)
	}

	def "测试2"() {
		setup:
		repository.list()
	}
}
