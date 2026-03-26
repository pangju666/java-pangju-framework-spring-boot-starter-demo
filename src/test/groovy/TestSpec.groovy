import io.github.pangju666.test.Application
import io.github.pangju666.test.document.TestDocument
import io.github.pangju666.test.repository.MongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class TestSpec extends Specification {
	@Autowired
	MongoRepository mongoRepository

	/*@Autowired
	TestRepository testRepository

	def "test"() {
		setup:
		def entity = testRepository.removeById(37L)
		def i = 1
	}*/

	def "测试是否正确装配Bean"() {
		expect:
		mongoRepository != null
		//ProxyUtils.getUserClass(mongoRepository) == SimpleBaseMongoRepository.class
		TestDocument document = mongoRepository.findOneByKeyValue("name", "test").get()
		assert document != null
	}
}
