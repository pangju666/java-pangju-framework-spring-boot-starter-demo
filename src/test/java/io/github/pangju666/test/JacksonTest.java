package io.github.pangju666.test;

import io.github.pangju666.commons.lang.utils.DateUtils;
import io.github.pangju666.framework.boot.jackson.annotation.DesensitizeFormat;
import io.github.pangju666.framework.boot.jackson.enums.DesensitizedType;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tools.jackson.databind.json.JsonMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@SpringBootTest
public class JacksonTest {
	@Autowired
	JsonMapper jsonMapper;

	@Data
	static class TestPOJO {
		Date date;
		Instant instant;
		LocalDate localDate;
		LocalDateTime localDateTime;
		LocalTime localTime;
		BigDecimal bigDecimal;
		BigInteger bigInteger;
		@DesensitizeFormat(type = DesensitizedType.PHONE_NUMBER)
		String str;
	}

	@Test
	public void serializeTest() {
		TestPOJO testVO = new TestPOJO();
		testVO.date = DateUtils.nowDate();
		testVO.instant = Instant.now();
		testVO.localDate = LocalDate.now();
		testVO.localDateTime = LocalDateTime.now();
		testVO.localTime = LocalTime.now();
		testVO.bigDecimal = new BigDecimal("9999999999999999999999999.77777777777777777777");
		testVO.bigInteger = new BigInteger("9999999999999999999999999");
		testVO.str = "18991938937";

		System.out.println(jsonMapper.writeValueAsString(testVO));
	}

	@Test
	public void deserializeTest() {
		String json = """
			{
				"bigDecimal":9999999999999999999999999.77777777777777777777,
				"bigInteger":9999999999999999999999999,
				"date":1767215663869,
				"instant":1767215663869,
				"localDate":"2026-01-01",
				"localDateTime":"2026-01-01T05:14:23",
				"localTime":"05:14:23",
				"str":"test"
			}
			""";

		TestPOJO testPOJO = jsonMapper.readValue(json, TestPOJO.class);
		System.out.println(testPOJO);
	}
}
