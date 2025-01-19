package com.newlearn.newlearn.article.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlearn.newlearn.article.dto.MainArticleResponseDto;
import com.newlearn.newlearn.article.service.ArticleService;
import com.newlearn.newlearn.common.exception.SuccessCode;
import com.newlearn.newlearn.common.response.BaseApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleService articleService;

	@Operation(summary = "기사 리스트 조회 API", description = "기사 리스트 조회 API입니다. 8시간 주기로 크롤링 해 온 네이버 뉴스를 Redis에 담고 만료시간을 당일 자정으로 설정했습니다.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "기사 리스트 조회 성공")
	})
	@GetMapping("/{categoryId}")
	public ResponseEntity<BaseApiResponse<MainArticleResponseDto>> getAllArticles(
		@PathVariable Long categoryId,
		@RequestParam int page,
		@RequestParam(required = false, defaultValue = "10") int size) {
		MainArticleResponseDto response = articleService.getArticles(categoryId, page, size);

		return BaseApiResponse.success(SuccessCode.SUCCESS_GET_ARTICLES, response);
	}
}
