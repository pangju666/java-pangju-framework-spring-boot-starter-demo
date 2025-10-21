package io.github.pangju666.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest(classes = Application.class)
class WebAdviceSpec extends Specification {
	@Autowired
	private WebApplicationContext context

	MockMvc mockMvc

	def setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
	}

	def "test-date-param-bind"() {
		setup:
		println mockMvc.perform(get("/test-date-param-bind").param("date", new Date().getTime().toString()))
			.andExpect(status().isOk())
			.andReturn()
			.response
			.getContentAsString()
	}
}
