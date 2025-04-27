package io.github.pangju666.test.service;

import io.github.pangju666.test.model.entity.TestDO;
import io.github.pangju666.test.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TestService {
	private final TestRepository testRepository;

	public List<TestDO> list() {
		return testRepository.list();
	}
}
