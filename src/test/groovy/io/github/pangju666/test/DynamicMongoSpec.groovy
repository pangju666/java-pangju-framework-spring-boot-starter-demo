package io.github.pangju666.test

import io.github.pangju666.commons.lang.utils.DateUtils
import io.github.pangju666.test.enums.TestEnum
import io.github.pangju666.test.model.dto.TestDTO
import io.github.pangju666.test.repository.MongoRepository1
import io.github.pangju666.test.repository.MongoRepository2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class DynamicMongoSpec extends Specification {
	/*@Qualifier("test1MongoTemplate")
	@Autowired
	MongoTemplate mongoTemplate1*/
	@Qualifier("test2MongoTemplate")
	@Autowired
	MongoTemplate mongoTemplate2
	@Autowired
	MongoTemplate mongoTemplate
	/*@Autowired
	GridFsTemplate gridFsTemplate*/
	@Autowired
	MongoRepository1 repository1
	@Autowired
	MongoRepository2 repository2

	def "test"() {
		setup:
		TestDTO testDTO = new TestDTO()
		testDTO.date = new Date()
		testDTO.localDate = DateUtils.toLocalDate(new Date())
		testDTO.localDateTime = DateUtils.toLocalDateTime(new Date())
		testDTO.testEnum = TestEnum.TEST_ENUM

		mongoTemplate.save(testDTO, "test")
		mongoTemplate2.save(testDTO, "test")
	}

	def "test2"() {
		setup:
		TestDTO testDTO = new TestDTO()
		testDTO.date = new Date()
		testDTO.localDate = DateUtils.toLocalDate(new Date())
		testDTO.localDateTime = DateUtils.toLocalDateTime(new Date())
		testDTO.testEnum = TestEnum.TEST_ENUM

		repository1.save(testDTO)
		repository2.save(testDTO)
	}
}
