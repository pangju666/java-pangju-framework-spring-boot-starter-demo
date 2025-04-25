package io.github.pangju666.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	private final Validator validator;

	public TestService(Validator validator) {
		this.validator = validator;
	}
}
