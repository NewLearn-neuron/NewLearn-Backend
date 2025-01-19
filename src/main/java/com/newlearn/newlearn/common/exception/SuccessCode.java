package com.newlearn.newlearn.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements BaseCode {
	// ----- [Test] ------ //
	TEST_SUCCESS(HttpStatus.OK, "테스트 성공"),

	// ----- [Articles] ------ //
	SUCCESS_GET_ARTICLES(HttpStatus.OK, "기사 리스트 조회 성공");

	private final HttpStatus status;
	private final String message;
}
