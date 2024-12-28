package com.newlearn.newlearn.user.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.newlearn.newlearn.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
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

	@Builder
	public User(String name, Long socialId, String platform) {
		this.name = name;
		this.socialId = socialId;
		this.platform = Platform.fromString(platform);
	}
}
