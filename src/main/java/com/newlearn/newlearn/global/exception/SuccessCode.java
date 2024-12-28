package com.newlearn.newlearn.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements BaseCode {
	// ----- [News] ------ //
	SHOW_NEWS_SUCCESS(HttpStatus.OK, "뉴스 상세 조회 성공");

	private final HttpStatus status;
	private final String message;
}
