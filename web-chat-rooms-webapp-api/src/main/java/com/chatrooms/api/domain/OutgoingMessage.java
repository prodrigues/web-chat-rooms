package com.chatrooms.api.domain;

import java.time.LocalDateTime;

public class OutgoingMessage extends Message {

	// TODO: consider timezone and the datetime value coming from the client?
	private LocalDateTime creationDate;
	
	public OutgoingMessage() {
		super();
		this.creationDate = null;
	}
	
	public OutgoingMessage(String text, String author, LocalDateTime creationDate) {
		super(text, author);
		this.creationDate = null;
	}
	
	public OutgoingMessage(Message incomingMessage, LocalDateTime creationDate) {
		super(incomingMessage.getText(), incomingMessage.getAuthor());
		this.creationDate = creationDate;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
}
