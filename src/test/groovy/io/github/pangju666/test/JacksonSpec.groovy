package io.github.pangju666.test

import io.github.pangju666.commons.lang.utils.DateUtils
import io.github.pangju666.commons.lang.utils.JsonUtils
import io.github.pangju666.test.enums.TestEnum
import io.github.pangju666.test.model.dto.TestDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = Application.class)
class JacksonSpec extends Specification {
	@Autowired
	private WebApplicationContext context

	MockMvc mockMvc

	def setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
	}

	def "test-json-serialize"() {
		setup:
		println mockMvc.perform(get("/test-json-serialize"))
			.andExpect(status().isOk())
			.andReturn()
			.response
			.getContentAsString()
	}

	def "test-json-deserialize"() {
		setup:
		TestDTO testDTO = new TestDTO()
		testDTO.date = new Date()
		testDTO.localDate = DateUtils.toLocalDate(new Date())
		testDTO.localDateTime = DateUtils.toLocalDateTime(new Date())
		testDTO.testEnum = TestEnum.TEST_ENUM

		println mockMvc.perform(post("/test-json-deserialize")
				.content(JsonUtils.toString(testDTO))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn()
			.response
			.getContentAsString()
	}
}
