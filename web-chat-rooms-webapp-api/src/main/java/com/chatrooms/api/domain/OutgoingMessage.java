package com.chatrooms.api.domain;

public class OutgoingMessage extends Message {

	private final boolean sent = true;

	public OutgoingMessage(Message incomingMessage) {
		super(incomingMessage.getText(), incomingMessage.getAuthor(), incomingMessage.getCreationDate());
	}

	public boolean isSent() {
		return sent;
	}

}