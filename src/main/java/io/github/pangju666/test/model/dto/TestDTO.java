package io.github.pangju666.test.model.dto;

import io.github.pangju666.framework.boot.enums.CryptoAlgorithm;
import io.github.pangju666.framework.boot.jackson.annotation.DecryptFormat;
import io.github.pangju666.test.enums.TestEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Document("test")
@Data
public class TestDTO {
	@Id
	private String id;
	private Date date;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	@NotBlank(message = "不可为空")
	@Length(min = 1, max = 100, message = "长度不足")
	@DecryptFormat(key = "91291358")
	private String str;
	@DecryptFormat(key = "91291358")
	private Integer str2;
	@DecryptFormat(key = "91291358")
	private BigDecimal bigDecimal;
	@DecryptFormat(key = "91291358")
	private BigInteger bigInteger;
	@DecryptFormat(key = "91291358")
	private TestEnum testEnum;
	@DecryptFormat(key = "91291358")
	private Map<String, String> map;
	@DecryptFormat(key = "91291358")
	private List<BigDecimal> list;
	@DecryptFormat(key = "91291358")
	private Collection<String> collection;
	@DecryptFormat(key = "91291358")
	private Set<BigInteger> set;
	//@DecryptFormat(key = "91291358")
	private A a;

	@Data
	public static class A {
		@DecryptFormat(key = "${test-private-key}", algorithm = CryptoAlgorithm.RSA)
		private BigDecimal a;
		private Integer a2;
	}
}
