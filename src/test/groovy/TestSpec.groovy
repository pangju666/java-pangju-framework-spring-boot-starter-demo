import io.github.pangju666.test.Application
import io.github.pangju666.test.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class TestSpec extends Specification {
	@Autowired
	TestRepository testRepository

	def "test"() {
		setup:
		def entity = testRepository.removeById(37L)
		def i = 1
	}
}
