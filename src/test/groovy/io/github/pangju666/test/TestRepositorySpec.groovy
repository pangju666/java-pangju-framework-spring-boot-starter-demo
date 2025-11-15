package io.github.pangju666.test

import io.github.pangju666.commons.image.enums.WatermarkDirection
import io.github.pangju666.framework.boot.image.core.impl.GMImageTemplate
import io.github.pangju666.framework.boot.image.model.GMImageOperation
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
	@Autowired
	GMImageTemplate imageTemplate

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
		def testDO = repository.getById(1000L)

		then:
		testDO.getLabel() == "suyMcmbDhu"
	}

	def "测试查询多条数据并排序"() {
		when:
		def testDO = repository.listByIdsOrderById(List.of(1L, 100L, 1000L))

		then:
		testDO.getFirst().getId() == 1L
	}

	def "测试查询多条数据并逆向排序"() {
		when:
		def testDO = repository.listByIdsOrderByyIdDesc(List.of(1L, 100L, 1000L))

		then:
		testDO.getFirst().getId() == 1000L
	}

	def "测试查询新数据并缓存"() {
		when:
		def testDO = repository.getById(10001L)

		then:
		testDO.getId() == 10001L && cacheManager.get("test_cache", "10001L")
	}

	def "a"() {
		setup:
		// 不支持中文路径
		File inputFile = new File("C:\\Users\\nullp\\Downloads\\IMG_20190830_154401.jpg")
		File outputFile = new File("C:\\Users\\nullp\\Downloads\\output.jpg")
		GMImageOperation imageOperation = GMImageOperation.builder()
			.watermarkText("test")
			//.watermarkImage(new File("C:\\Users\\nullp\\Downloads\\watermark.png"))
			.watermarkDirection(WatermarkDirection.TOP_RIGHT)
			.watermarkTextFontName("Arial")
			//.watermarkTextFontSize(30)
		//.watermarkPosition(20, 20)
		//.textWatermarkFontSize(100)
		//.imageWatermarkScaleRatio(0.5)
		//.resizeFilter(ResampleFilter.LANCZOS)
		//.quality(75)
			//.cropByOffset(20, 20, 20, 20)
			.scaleByRange(500, 500)
			.stripProfiles(true)
			.build()
		imageTemplate.execute(inputFile, outputFile, imageOperation)
	}
}
