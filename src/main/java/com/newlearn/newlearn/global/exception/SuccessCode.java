package com.newlearn.newlearn.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements BaseCode {
	// ----- [Test] ------ //
	TEST_SUCCESS(HttpStatus.OK, "테스트 성공");

	private final HttpStatus status;
	private final String message;
}
