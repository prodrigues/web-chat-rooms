package com.chatrooms.api.domain;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Message {
	private String text;
	private String author;
	private ZonedDateTime creationDate;
	
	protected Message() {
		this("", "");
	}

	public Message(String text, String author) {
		this(text, author, ZonedDateTime.now());
	}
	
	public Message(String text, String author, ZonedDateTime creationDate) {
		this.setText(text);
		this.setAuthor(author);
		this.setCreationDate(creationDate);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = Objects.requireNonNull(text);
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = Objects.requireNonNull(author);
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = Objects.requireNonNull(creationDate);
	}
	
}