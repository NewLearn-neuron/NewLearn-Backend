package com.newlearn.newlearn;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlearn.newlearn.common.exception.SuccessCode;
import com.newlearn.newlearn.common.response.BaseApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TestController {

	@Operation(summary = "테스트 API", description = "Swagger 테스트용 API입니다.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "테스트 성공")
	})
	@GetMapping("/test1")
	public ResponseEntity<BaseApiResponse<String>> test() {
		return BaseApiResponse.success(SuccessCode.TEST_SUCCESS);
	}

	@Operation(summary = "data 포함 테스트 API", description = "Swagger data 포함 테스트 API입니다.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "테스트 성공")
	})
	@GetMapping("/test2")
	public ResponseEntity<BaseApiResponse<String>> testWithData() {
		String data = "test";
		return BaseApiResponse.success(SuccessCode.TEST_SUCCESS, data);
	}
}
