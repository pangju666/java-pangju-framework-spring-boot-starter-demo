package io.github.pangju666.test.web;

import io.github.pangju666.framework.web.model.common.Result;
import io.github.pangju666.framework.web.model.dto.RequiredListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class WebController {
	@PostMapping("/test")
	public ResponseEntity<Result<RequiredListDTO<String>>> test(@RequestBody RequiredListDTO<String> requiredListDTO) {
		return ResponseEntity.ok(Result.ok(requiredListDTO));
	}
}
