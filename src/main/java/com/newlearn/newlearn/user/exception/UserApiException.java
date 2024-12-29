package com.newlearn.newlearn.user.exception;

import com.newlearn.newlearn.common.exception.ApiException;
import com.newlearn.newlearn.common.exception.BaseCode;

public class UserApiException extends ApiException {
	public UserApiException(BaseCode code) {
		super(code);
	}
}
