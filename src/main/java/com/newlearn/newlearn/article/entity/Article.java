package com.newlearn.newlearn.article.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.newlearn.newlearn.category.entity.Category;
import com.newlearn.newlearn.common.BaseTimeEntity;
import com.newlearn.newlearn.article_history.entity.ArticleHistory;
import com.newlearn.newlearn.article_image.entity.ArticleImage;
import com.newlearn.newlearn.scraped_article.entity.ScrapedArticle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Long id;
	@Column(length = 200)
	private String title;
	@Column(columnDefinition = "TEXT")
	private String content;
	@ColumnDefault("'ACTIVE'")
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_agency_id")
	private ArticleAgency articleAgency;
	@OneToMany(mappedBy = "article")
	private List<ArticleImage> articleImages = new ArrayList<>();
	@OneToMany(mappedBy = "article")
	private List<ScrapedArticle> scrapedArticles = new ArrayList<>();
	@OneToMany(mappedBy = "article")
	private List<ArticleHistory> articleHistories = new ArrayList<>();
}
