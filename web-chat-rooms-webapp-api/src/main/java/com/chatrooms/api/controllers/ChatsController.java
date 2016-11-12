package com.chatrooms.api.controllers;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chatrooms.api.domain.Message;
import com.chatrooms.api.domain.OutgoingMessage;

@Controller
public class ChatsController {

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutgoingMessage sendMessage(Message message) {
		return new OutgoingMessage(message, LocalDateTime.now());
	}
}
