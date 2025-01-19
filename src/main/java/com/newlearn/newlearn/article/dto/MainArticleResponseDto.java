package com.newlearn.newlearn.article.dto;

import java.util.List;

import com.newlearn.newlearn.article.entity.RedisArticle;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MainArticleResponseDto {
	private List<RedisArticle> articles;
	private boolean hasNext;

	@Builder
	public MainArticleResponseDto(List<RedisArticle> articles, boolean hasNext) {
		this.articles = articles;
		this.hasNext = hasNext;
	}

	public static MainArticleResponseDto toDto(List<RedisArticle> redisArticles, boolean hasNext) {
		return MainArticleResponseDto.builder()
			.articles(redisArticles)
			.hasNext(hasNext)
			.build();
	}
}
