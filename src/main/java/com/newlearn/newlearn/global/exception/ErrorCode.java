package com.newlearn.newlearn.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements BaseCode {
	// ---- [News] ---- //
	NOT_EXIST_NEWS(HttpStatus.BAD_REQUEST, "존재하지 않는 뉴스입니다.");

	private final HttpStatus status;
	private final String message;
}
