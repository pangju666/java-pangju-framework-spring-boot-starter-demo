package io.github.pangju666.test.model.dto;

import io.github.pangju666.framework.autoconfigure.enums.Algorithm;
import io.github.pangju666.framework.autoconfigure.jackson.annotation.DecryptFormat;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	private String str;
	private BigDecimal bigDecimal;
	private BigInteger bigInteger;
	private TestEnum testEnum;
	@DecryptFormat(algorithm = Algorithm.BASE64)
	private Map<Date, String> map;
	@DecryptFormat(algorithm = Algorithm.BASE64)
	private List<String> list;
}
