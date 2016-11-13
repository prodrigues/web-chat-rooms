package com.chatrooms.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfig {

	@Bean
	Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		return new Jackson2ObjectMapperBuilder()
				// disable Module.class lookup, because it will register the
				// JSR310Module.class that isn't compatible with the ISO 8601
				// date format.
				// FIX: automatic lookup can be enabled again when the
				// JSR310Module.class is removed.
				.findModulesViaServiceLoader(false)
				// disable timestamps will enable serialization in the ISO8601
				// format
				.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.featuresToDisable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
	}
}
