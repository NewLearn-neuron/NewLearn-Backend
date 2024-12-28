package com.newlearn.newlearn.user.entity;

import com.newlearn.newlearn.common.exception.ErrorCode;
import com.newlearn.newlearn.user.exception.UserApiException;

public enum Platform {
	KAKAO, NAVER;

	public static Platform fromString(String platform) throws UserApiException {
		try {
			return Platform.valueOf(platform.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new UserApiException(ErrorCode.NOT_EXIST_PLATFORM);
		}
	}
}
