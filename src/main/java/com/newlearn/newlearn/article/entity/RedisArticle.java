package com.newlearn.newlearn.article.entity;

import java.io.Serializable;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RedisArticle implements Serializable {
	private Long articleId;
	private String title;
	private String source;
	private String publishedDate;
	private String thumbnail;
	private String content;
}
