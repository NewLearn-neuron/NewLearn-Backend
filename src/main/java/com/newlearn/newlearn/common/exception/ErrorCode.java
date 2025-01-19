package com.newlearn.newlearn.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements BaseCode {
	// ---- [User] ---- //
	NOT_EXIST_PLATFORM(HttpStatus.BAD_REQUEST, "존재하지 않는 플랫폼입니다" );

	private final HttpStatus status;
	private final String message;
}
