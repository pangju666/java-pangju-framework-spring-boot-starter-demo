package io.github.pangju666.test.model.vo;

import io.github.pangju666.framework.boot.enums.CryptoAlgorithm;
import io.github.pangju666.framework.boot.jackson.annotation.EncryptFormat;
import io.github.pangju666.test.enums.TestEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

//@DesensitizeFormat(type = DesensitizedType.PHONE_NUMBER)
@Data
public class TestVO {
	private Date date;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	private TestEnum testEnum;
	@EncryptFormat(key = "91291358")
	private BigDecimal bigDecimal;
	@EncryptFormat(key = "91291358")
	private BigInteger bigInteger;
	private Duration duration;
	@EncryptFormat(key = "91291358")
	private Double doubleValue;
	@EncryptFormat(key = "91291358")
	//@EncryptFormat(algorithm = Algorithm.BASE64)
	private String phoneNumber;
	@EncryptFormat(key = "91291358")
	private byte[] bytes;
	@EncryptFormat(key = "91291358")
	private List<Map<Integer, List<Map<String, List<String>>>>> list;
	@EncryptFormat(key = "91291358")
	private Map<String, List<Long>> map;
	@EncryptFormat(key = "91291358")
	private List<A> a;

	@Data
	public static class A {
		@EncryptFormat(key = "${test-public-key}", algorithm = CryptoAlgorithm.RSA)
		private BigDecimal a;
	}
}
