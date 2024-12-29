package com.newlearn.newlearn.news.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.newlearn.newlearn.category.entity.Category;
import com.newlearn.newlearn.common.BaseTimeEntity;
import com.newlearn.newlearn.news_history.entity.NewsHistory;
import com.newlearn.newlearn.news_image.entity.NewsImage;
import com.newlearn.newlearn.scraped_news.entity.ScrapedNews;

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
public class News extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
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
	@JoinColumn(name = "news_agency_id")
	private NewsAgency newsAgency;
	@OneToMany(mappedBy = "news")
	private List<NewsImage> newsImages = new ArrayList<>();
	@OneToMany(mappedBy = "news")
	private List<ScrapedNews> scrapedNews = new ArrayList<>();
	@OneToMany(mappedBy = "news")
	private List<NewsHistory> newsHistories = new ArrayList<>();
}
