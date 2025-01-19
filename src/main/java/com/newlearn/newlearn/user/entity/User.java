package com.newlearn.newlearn.user.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.newlearn.newlearn.common.BaseTimeEntity;
import com.newlearn.newlearn.like_category.entity.LikeCategory;
import com.newlearn.newlearn.news_history.entity.NewsHistory;
import com.newlearn.newlearn.scraped_news.entity.ScrapedNews;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@DynamicInsert
@Entity(name = "`user`")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	@Column(length = 30)
	private String name;
	private Long socialId;
	@Column(length = 10)
	@ColumnDefault("'ACTIVE'")
	private String status;
	@Column(length = 20)
	@Enumerated(value = EnumType.STRING)
	private Platform platform;
	@OneToMany(mappedBy = "user")
	private List<LikeCategory> likeCategories = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<ScrapedNews> scrapedNews = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<NewsHistory> newsHistories = new ArrayList<>();
}
