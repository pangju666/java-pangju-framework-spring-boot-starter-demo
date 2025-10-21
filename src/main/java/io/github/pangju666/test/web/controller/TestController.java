package io.github.pangju666.test.web.controller;

import io.github.pangju666.commons.lang.utils.DateUtils;
import io.github.pangju666.framework.autoconfigure.enums.Algorithm;
import io.github.pangju666.framework.autoconfigure.web.advice.wrapper.ResponseBodyWrapper;
import io.github.pangju666.framework.autoconfigure.web.crypto.advice.EncryptResponseBody;
import io.github.pangju666.framework.autoconfigure.web.crypto.resolver.EncryptRequestParam;
import io.github.pangju666.framework.autoconfigure.web.idempotent.annotation.Idempotent;
import io.github.pangju666.framework.autoconfigure.web.resolver.EnumRequestParam;
import io.github.pangju666.framework.autoconfigure.web.signature.annotation.Signature;
import io.github.pangju666.framework.autoconfigure.web.signature.enums.SignatureType;
import io.github.pangju666.framework.web.model.common.Result;
import io.github.pangju666.test.enums.TestEnum;
import io.github.pangju666.test.model.dto.TestDTO;
import io.github.pangju666.test.model.entity.TestDO;
import io.github.pangju666.test.model.vo.TestVO;
import io.github.pangju666.test.model.vo.TestVO2;
import io.github.pangju666.test.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ResponseBodyWrapper
@AllArgsConstructor
@RequestMapping
@RestController
public class TestController {
	private final TestService testService;

	//@RateLimit(rate = 1, timeUnit = TimeUnit.HOURS, scope = RateLimitScope.SOURCE)
	@GetMapping("/test-json-serialize")
	public ResponseEntity<TestVO> testJsonSerialize() {
		TestVO testVO = new TestVO();
		testVO.setDate(new Date());
		testVO.setLocalDate(DateUtils.toLocalDate(new Date()));
		testVO.setLocalDateTime(DateUtils.toLocalDateTime(new Date()));
		testVO.setTestEnum(TestEnum.TEST_ENUM);
		testVO.setBigInteger(BigInteger.TEN);
		testVO.setBigDecimal(BigDecimal.valueOf(103333333333333333333333.3333));
		testVO.setDuration(Duration.ofHours(1));
		testVO.setDoubleValue(111111111111111111111111111111111111111111111111111111111111d);
		testVO.setPhoneNumber("18991938938");
		return ResponseEntity.ok(testVO);
	}

	@Idempotent(prefix = "test", key = "#p0.id", timeUnit = TimeUnit.MINUTES)
	@PostMapping("/test-json-deserialize")
	public ResponseEntity<Void> testJsonDeserialize(@RequestBody /*@DecryptRequestBody(algorithm = Algorithm.BASE64) */TestDTO testDTO) {
		return ResponseEntity.ok().build();
	}

	@PostMapping("/test-validate")
	public ResponseEntity<Void> testValidate(@RequestBody @Validated TestDTO testDTO) {
		return ResponseEntity.ok().build();
	}

	@Signature(appId = "test", type = SignatureType.PARAMS)
	@GetMapping("/test-hash-cache")
	public ResponseEntity<List<TestDO>> testHashCache() {
		return ResponseEntity.ok(testService.list());
	}

	@GetMapping("/test-list")
	public List<TestDO> testList() {
		return testService.list();
	}

	@GetMapping("/test-dynamic-redis")
	public ResponseEntity<String> testDynamicRedis(@RequestParam String key1, @RequestParam String key2) {
		return ResponseEntity.ok(testService.getRedisValue(key1, key2));
	}

	@GetMapping("/test-date-param-bind")
	public Result<String> testDateParamBind(@RequestParam LocalDate date) {
		return Result.ok("test");
	}

	@GetMapping("/test-response-body-wrapper-string")
	public String testResponseBodyWrapperString() {
		return "test";
	}

	@GetMapping("/test-response-body-wrapper-bytes")
	public byte[] testResponseBodyWrapperBytes() {
		return "test".getBytes();
	}

	@GetMapping("/test-response-body-wrapper-entity")
	public ResponseEntity<String> testResponseBodyWrapperEntity() {
		return ResponseEntity.ok("test");
	}

	@GetMapping(value = "/test-response-body-wrapper-json")
	public @EncryptResponseBody(algorithm = Algorithm.BASE64) TestVO2 testResponseBodyWrapperJson() {
		TestVO2 testVO = new TestVO2();
		testVO.setDate(new Date());
		testVO.setLocalDate(DateUtils.toLocalDate(new Date()));
		testVO.setLocalDateTime(DateUtils.toLocalDateTime(new Date()));
		testVO.setTestEnum(TestEnum.TEST_ENUM);
		testVO.setBigInteger(BigInteger.TEN);
		testVO.setBigDecimal(BigDecimal.valueOf(103333333333333333333333.3333));
		testVO.setDoubleValue(111111111111111111111111111111111111111111111111111111111111d);
		testVO.setPhoneNumber("18991938938");
		testVO.setPhoneNumber2("18991938931");
		testVO.setPhoneNumbers(List.of("18991938932"));
		testVO.setMap(Map.of("123", "18991938932"));
		testVO.setIntList(List.of(123));
		testVO.setIntMap(Map.of("123", 13211313));
		return testVO;
	}

	@GetMapping(value = "test-enum-request-param")
	public String testEnumRequestParam(@EnumRequestParam(value = "test") TestEnum testEnum) {
		return testEnum.name();
	}

	@GetMapping(value = "test-encrypt-request-param")
	public String testEncryptRequestParam(@EncryptRequestParam(algorithm = Algorithm.BASE64) String value) {
		return value;
	}
}
