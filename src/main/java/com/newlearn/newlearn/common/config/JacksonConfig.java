package com.newlearn.newlearn.common.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonConfig {
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new SimpleModule().addSerializer(String.class, new JsonSerializer<>() {
			@Override
			public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				if (value != null) {
					gen.writeString(value.replace("\n", "<br/>")); // 또는 "  "
				} else {
					gen.writeNull();
				}
			}
		}));
		return objectMapper;
	}
}
