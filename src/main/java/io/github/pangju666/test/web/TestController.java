package io.github.pangju666.test.web;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {
	@GetMapping("/test")
	public void test(HttpServletResponse response) {
		response.setHeader("test", "tetst");
	}
}
