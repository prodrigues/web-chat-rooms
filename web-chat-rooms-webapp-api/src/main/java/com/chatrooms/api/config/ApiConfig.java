package com.chatrooms.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan({ "com.chatrooms.api.controllers" })
@Import({ JacksonConfig.class, WebSocketConfig.class })
public class ApiConfig extends WebMvcConfigurationSupport {

	private Jackson2ObjectMapperBuilder objectMapperBuilder;
	
	@Autowired
	ApiConfig(Jackson2ObjectMapperBuilder objectMapperBuilder) {
		this.objectMapperBuilder = objectMapperBuilder;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter(this.objectMapperBuilder.build()));
		// enable if necessary to serialize/deserialize XML
		//converters.add(new MappingJackson2XmlHttpMessageConverter(this.objectMapperBuilder.createXmlMapper(true).build()));
		
		addDefaultHttpMessageConverters(converters);
	}
}