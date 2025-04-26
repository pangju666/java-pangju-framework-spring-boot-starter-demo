package io.github.pangju666.test.service;

import io.github.pangju666.test.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TestService {
	private final TestRepository testRepository;
}
