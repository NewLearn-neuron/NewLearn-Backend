package com.newlearn.newlearn.article.exception;

import com.newlearn.newlearn.common.exception.ApiException;
import com.newlearn.newlearn.common.exception.BaseCode;

public class ArticleException extends ApiException {
	public ArticleException(BaseCode code) {
		super(code);
	}
}
