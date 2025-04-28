package io.github.pangju666.test

import io.github.pangju666.test.model.entity.TestDO
import io.github.pangju666.test.repository.TestRepository
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class TestRepositorySpec extends Specification {
	@Autowired
	TestRepository repository

	def "测试逻辑删除"() {
		setup:
		repository.removeById(1L)
	}

	def "添加随机数据"() {
		setup:
		List<TestDO> testDOList = new ArrayList<>(10000)
		for (i in 0..<10000) {
			testDOList.add(new TestDO(RandomStringUtils.insecure().nextAlphabetic(10)))
		}
		repository.saveBatch(testDOList)
	}

	def "测试查询全部数据"() {
		when:
		def list = repository.list()

		then:
		list.size() == 10000
	}

	def "测试查询单条数据"() {
		when:
		def testDO = repository.getById(10003L)

		then:
		testDO.getLabel() == "mAmhnTwfHt"
	}

	def "测试查询多条数据"() {
		when:
		def testDO = repository.listByIds(List.of(10003L, 10021L, 10020L))

		then:
		testDO.size() == 3
	}
}
