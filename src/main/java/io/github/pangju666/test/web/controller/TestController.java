package io.github.pangju666.test.web.controller;

import io.github.pangju666.commons.lang.utils.DateUtils;
import io.github.pangju666.framework.autoconfigure.web.annotation.wrapper.ResponseBodyWrapper;
import io.github.pangju666.test.enums.TestEnum;
import io.github.pangju666.test.model.dto.TestDTO;
import io.github.pangju666.test.model.entity.TestDO;
import io.github.pangju666.test.model.vo.TestVO;
import io.github.pangju666.test.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@ResponseBodyWrapper
@AllArgsConstructor
@RequestMapping
@RestController
public class TestController {
	private final TestService testService;

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

	@PostMapping("/test-json-deserialize")
	public ResponseEntity<Void> testJsonDeserialize(@RequestBody TestDTO testDTO) {
		return ResponseEntity.ok().build();
	}

	@GetMapping("/test-hash-cache")
	public ResponseEntity<List<TestDO>> testHashCache() {
		return ResponseEntity.ok(testService.list());
	}
}
