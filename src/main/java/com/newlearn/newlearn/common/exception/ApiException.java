package com.newlearn.newlearn.common.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
	private final BaseCode baseCode;

	public ApiException(BaseCode code) {
		super(code.getMessage());
		this.baseCode = code;
	}
}