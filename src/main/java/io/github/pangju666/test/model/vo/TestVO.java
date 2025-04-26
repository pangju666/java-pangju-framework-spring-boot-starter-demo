package io.github.pangju666.test.model.vo;

import io.github.pangju666.framework.autoconfigure.jackson.annotation.DesensitizeFormat;
import io.github.pangju666.framework.autoconfigure.jackson.enums.DesensitizedType;
import io.github.pangju666.test.enums.TestEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TestVO {
	private Date date;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	private TestEnum testEnum;
	private BigDecimal bigDecimal;
	private BigInteger bigInteger;
	private Duration duration;
	private Double doubleValue;
	@DesensitizeFormat(type = DesensitizedType.PHONE_NUMBER)
	private String phoneNumber;
}
