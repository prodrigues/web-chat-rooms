package com.chatrooms.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.chatrooms.api.controllers"})
@Import({WebSocketConfig.class})
public class ApiConfig {

}
