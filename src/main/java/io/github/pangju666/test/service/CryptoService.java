package io.github.pangju666.test.service;

import io.github.pangju666.framework.boot.crypto.factory.impl.AES256CryptoFactory;
import io.github.pangju666.framework.boot.crypto.factory.impl.BasicCryptoFactory;
import io.github.pangju666.framework.boot.crypto.factory.impl.RSACryptoFactory;
import io.github.pangju666.framework.boot.crypto.factory.impl.StrongCryptoFactory;
import org.springframework.stereotype.Service;

@Service
public class CryptoService {
	private final StrongCryptoFactory strongCryptoFactory;
	private final BasicCryptoFactory basicCryptoFactory;
	private final AES256CryptoFactory aes256CryptoFactory;
	private final RSACryptoFactory rsaCryptoFactory;

	public CryptoService(StrongCryptoFactory strongCryptoFactory, BasicCryptoFactory basicCryptoFactory,
						 AES256CryptoFactory aes256CryptoFactory, RSACryptoFactory rsaCryptoFactory) {
		this.strongCryptoFactory = strongCryptoFactory;
		this.basicCryptoFactory = basicCryptoFactory;
		this.aes256CryptoFactory = aes256CryptoFactory;
		this.rsaCryptoFactory = rsaCryptoFactory;
	}
}
