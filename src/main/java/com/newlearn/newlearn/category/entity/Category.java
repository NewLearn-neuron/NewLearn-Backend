package com.newlearn.newlearn.category.entity;

import java.util.ArrayList;
import java.util.List;

import com.newlearn.newlearn.like_category.entity.LikeCategory;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;
	@Column(length = 30)
	private String name;
	@OneToMany(mappedBy = "category")
	private List<LikeCategory> likeCategories = new ArrayList<>();
}
