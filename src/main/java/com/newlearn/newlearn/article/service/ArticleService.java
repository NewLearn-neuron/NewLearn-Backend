package com.newlearn.newlearn.article.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newlearn.newlearn.article.dto.MainArticleResponseDto;
import com.newlearn.newlearn.article.entity.RedisArticle;
import com.newlearn.newlearn.article.exception.ArticleException;
import com.newlearn.newlearn.common.exception.ErrorCode;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
	private static final String REDIS_KEY = "articles:category:";
	private static final int NEXT_PAGE_OFFSET = 1;

	private final RedisTemplate<String, String> redisTemplate;
	private final ObjectMapper objectMapper;

	public MainArticleResponseDto getArticles(Long categoryId, int page, int size) {
		String redisKey = generateRedisKey(categoryId);

		String jsonString = redisTemplate.opsForValue().get(redisKey);
		if (jsonString == null || jsonString.isEmpty()) {
			throw new ArticleException(ErrorCode.NOT_EXIST_ARTICLE_BY_CATEGORY);
		}
		List<RedisArticle> articles = deserializeArticles(jsonString);

		List<RedisArticle> pagedArticles = paginateArticles(articles, page, size);
		boolean hasNext = (page + NEXT_PAGE_OFFSET) * size < articles.size();

		return MainArticleResponseDto.toDto(pagedArticles, hasNext);
	}

	private String generateRedisKey(Long categoryId) {
		return REDIS_KEY + categoryId;
	}

	// JSON 문자열을 리스트로 변환
	private List<RedisArticle> deserializeArticles(String jsonString) {
		try {
			return objectMapper.readValue(jsonString,
				objectMapper.getTypeFactory().constructCollectionType(List.class, RedisArticle.class));
		} catch (Exception e) {
			throw new ArticleException(ErrorCode.FAILED_TO_PARSE_JSON_TO_LIST);
		}
	}

	// 페이지네이션 처리
	private List<RedisArticle> paginateArticles(List<RedisArticle> articles, int page, int size) {
		int start = page * size;
		if (start >= articles.size()) {
			return List.of();
		}
		int end = Math.min(start + size, articles.size());

		return articles.subList(start, end);
	}
}

