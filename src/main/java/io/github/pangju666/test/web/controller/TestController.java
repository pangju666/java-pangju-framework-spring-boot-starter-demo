package io.github.pangju666.test.web.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import io.github.pangju666.commons.lang.utils.DateUtils;
import io.github.pangju666.framework.boot.enums.CryptoAlgorithm;
import io.github.pangju666.framework.boot.web.advice.DecryptRequestBody;
import io.github.pangju666.framework.boot.web.advice.EncryptResponseBody;
import io.github.pangju666.framework.boot.web.advice.ResponseBodyWrapperIgnore;
import io.github.pangju666.framework.boot.web.resolver.EncryptRequestParam;
import io.github.pangju666.framework.boot.web.resolver.EnumRequestParam;
import io.github.pangju666.framework.boot.web.signature.annotation.Signature;
import io.github.pangju666.framework.web.model.Result;
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
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
		testVO.setBigDecimal(BigDecimal.valueOf(10000.333));
		testVO.setDuration(Duration.ofHours(1));
		testVO.setDoubleValue(10000.333);
		testVO.setPhoneNumber("18991938938");
		testVO.setBytes("18991938938".getBytes());
		testVO.setList(List.of(Map.of(1, List.of(Map.of("test", List.of("18991938938"))))));
		testVO.setMap(Map.of("test", List.of(1L)));
		TestVO.A a = new TestVO.A();
		a.setA(BigDecimal.valueOf(100));
		testVO.setA(List.of(a));
		return ResponseEntity.ok(testVO);
	}

	//@Idempotent(prefix = "test", key = "#p0.id", timeUnit = TimeUnit.MINUTES)
	@PostMapping("/test-json-deserialize")
	public ResponseEntity<TestDTO> testJsonDeserialize(@RequestBody /*@DecryptRequestBody(algorithm = Algorithm.BASE64) */TestDTO testDTO) {
		return ResponseEntity.ok(testDTO);
	}

	@PostMapping("/test-validate")
	public ResponseEntity<Void> testValidate(@RequestBody @Validated TestDTO testDTO) {
		return ResponseEntity.ok().build();
	}

	@Signature(appId = "test", type = Signature.SignatureType.PARAMS)
	@GetMapping("/test-hash-cache")
	public ResponseEntity<List<TestDO>> testHashCache() {
		return ResponseEntity.ok(testService.list());
	}

	@GetMapping("/test-list")
	public @ResponseBody List<TestDO> testList() {
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

	@ResponseBodyWrapperIgnore
	@GetMapping(value = "/test-response-body-wrapper-json")
	public @EncryptResponseBody(key = "91291358") TestVO2 testResponseBodyWrapperJson() {
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

	@PostMapping(value = "/test-decrypt-json")
	public TestVO2 testDecryptJson(@RequestBody @DecryptRequestBody(key = "91291358") TestVO2 testVO2) {
		return testVO2;
	}

	@ResponseBodyWrapperIgnore
	@GetMapping(value = "/test-encrypt-string")
	public @EncryptResponseBody(key = "91291358") String testEncryptString() {
		return new String("Hello World".getBytes(), StandardCharsets.ISO_8859_1);
	}

	@ResponseBodyWrapperIgnore
	@PostMapping(value = "/test-decrypt-string")
	public String testEncryptString(@RequestBody @DecryptRequestBody(key = "91291358") String testEncryptString) {
		return testEncryptString;
	}

	@GetMapping(value = "/test-encrypt-bytes")
	public @EncryptResponseBody(key = "91291358") byte[] testEncryptBytes() {
		return "Hello World".getBytes();
	}

	@GetMapping(value = "test-enum-request-param")
	public String testEnumRequestParam(@EnumRequestParam(value = "test") TestEnum testEnum) {
		return testEnum.name();
	}

	@GetMapping(value = "test-encrypt-request-param")
	public String testEncryptRequestParam(@EncryptRequestParam(key = "91291358", algorithm = CryptoAlgorithm.AES256) String value) {
		return value;
	}

	@GetMapping(value = "/test-response")
	public JsonElement testEncryptRequestParam() {
		return new JsonPrimitive("Hello World");
	}
}
