package io.github.pangju666.test

import io.github.pangju666.commons.lang.utils.JsonUtils
import io.github.pangju666.test.model.dto.TestDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@SpringBootTest(classes = Application.class)
class ValidationSpec extends Specification {
	@Autowired
	private WebApplicationContext context

	MockMvc mockMvc

	def setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
	}

	def "test-validate"() {
		setup:
		TestDTO testDTO = new TestDTO()
		testDTO.str = null

		println mockMvc.perform(post("/test-validate")
				.content(JsonUtils.toString(testDTO))
				.contentType(MediaType.APPLICATION_JSON))
			.andReturn()
			.response
			.getContentAsString()
	}
}
