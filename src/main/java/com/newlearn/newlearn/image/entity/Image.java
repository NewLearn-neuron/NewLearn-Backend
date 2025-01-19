package com.newlearn.newlearn.image.entity;

import java.util.ArrayList;
import java.util.List;

import com.newlearn.newlearn.news_image.entity.NewsImage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long id;
	@Column(length = 2048)
	private String url;
	private boolean isThumbnail;
	@OneToMany(mappedBy = "image")
	private List<NewsImage> newsImages = new ArrayList<>();
}
