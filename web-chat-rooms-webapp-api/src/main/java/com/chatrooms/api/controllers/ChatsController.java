package com.chatrooms.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
		return new OutgoingMessage(message);
	}
	
	public static void main(String[] args) {
		String pattern = "MM-dd-yyyy hh:mm:ss";
		System.out.println(ZoneId.systemDefault());
		
		ZonedDateTime d2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Paris"));
		System.out.println(d2 + " - > " + d2.withZoneSameInstant(ZoneId.systemDefault()));
		ZonedDateTime d = ZonedDateTime.parse("2016-11-12T12:03:21.469Z");
		System.out.println(d.toString() + " -> " + d.getZone());
		ZonedDateTime d1 = ZonedDateTime.now();
		System.out.println(d1 + " -> " + d1.getZone());
	}
}
