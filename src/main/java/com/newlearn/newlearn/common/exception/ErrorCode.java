package com.newlearn.newlearn.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements BaseCode {
	// ---- [User] ---- //
	NOT_EXIST_PLATFORM(HttpStatus.BAD_REQUEST, "존재하지 않는 플랫폼입니다" ),

	// ---- [Article] ---- //
	NOT_EXIST_ARTICLE_BY_CATEGORY(HttpStatus.INTERNAL_SERVER_ERROR, "카테고리에 해당하는 뉴스가 존재하지 않습니다."),
	FAILED_TO_PARSE_JSON_TO_LIST(HttpStatus.BAD_REQUEST, "문자열을 리스트 형식으로 변환할 수 없습니다.");

	private final HttpStatus status;
	private final String message;
}
