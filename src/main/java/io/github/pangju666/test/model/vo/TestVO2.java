package io.github.pangju666.test.model.vo;

import io.github.pangju666.test.enums.TestEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class TestVO2 {
	private Date date;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	private TestEnum testEnum;
	private BigDecimal bigDecimal;
	private BigInteger bigInteger;
	private Double doubleValue;
	//@DesensitizeFormat(type = DesensitizedType.PHONE_NUMBER)
	//@EncryptFormat(algorithm = Algorithm.BASE64)
	private String phoneNumber;
	//@EncryptFormat(algorithm = Algorithm.BASE64)
	private String phoneNumber2;
	//@EncryptFormat(key = "", algorithm = Algorithm.AES256)
	private List<String> phoneNumbers;
	//@EncryptFormat(key = "", algorithm = Algorithm.AES256)
	private Map<String, String> map;
	//@EncryptFormat(key = "", algorithm = Algorithm.AES256)
	private Map<String, Integer> intMap;
	//@EncryptFormat(key = "", algorithm = Algorithm.AES256)
	private List<Integer> intList;
}
