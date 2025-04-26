package io.github.pangju666.test.model.dto;

import io.github.pangju666.test.enums.TestEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Data
public class TestDTO {
	private Date date;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	private BigDecimal bigDecimal;
	private BigInteger bigInteger;
	private TestEnum testEnum;
	private Map<Date, String> map;
}
