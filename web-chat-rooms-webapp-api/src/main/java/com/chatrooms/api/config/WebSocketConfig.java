package com.chatrooms.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan({"com.chatrooms.api.controllers"})
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	private Jackson2ObjectMapperBuilder objectMapperBuilder;

	@Autowired
	WebSocketConfig(Jackson2ObjectMapperBuilder objectMapperBuilder) {
		this.objectMapperBuilder = objectMapperBuilder;
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").withSockJS();
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		// The objectMapper for websockets isn't shared with the objectMapper
		// for the rest of the Spring MVC framework:
		// https://github.com/spring-projects/spring-boot/issues/2445

		DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
		resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setObjectMapper(this.objectMapperBuilder.build());
		converter.setContentTypeResolver(resolver);
		messageConverters.add(converter);

		return false;
	}

}
