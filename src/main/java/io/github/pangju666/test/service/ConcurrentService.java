package io.github.pangju666.test.service;

import io.github.pangju666.framework.boot.concurrent.KeyBasedLockExecutor;
import org.springframework.stereotype.Service;

@Service
public class ConcurrentService {
	private final KeyBasedLockExecutor executor;

	public ConcurrentService(KeyBasedLockExecutor executor) {
		this.executor = executor;
	}

	public void test() throws Exception {
		executor.executeWithLock("test", (key) -> key);
	}
}
