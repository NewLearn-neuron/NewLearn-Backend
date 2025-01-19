package com.newlearn.newlearn.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.newlearn.newlearn.common.response.BaseApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApiException.class)
	protected ResponseEntity<BaseApiResponse<Void>> handleCustomException(ApiException exception) {
		BaseCode errorCode = exception.getBaseCode();
		log.warn("ApiException handling: {}", exception.getMessage());
		return BaseApiResponse.fail(errorCode);
	}
}
