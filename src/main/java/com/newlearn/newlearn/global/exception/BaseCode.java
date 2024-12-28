package com.newlearn.newlearn.global.exception;

import org.springframework.http.HttpStatus;

public interface BaseCode {
	HttpStatus getStatus();
	String getMessage();
}
