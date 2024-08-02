package com.joselucio.springMongocourse.entities;

import java.io.Serializable;

public class Comments implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	private LinkedinUser user;
	
	public Comments() {
		
	}

	public Comments(String text, LinkedinUser user) {
		super();
		this.text = text;
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LinkedinUser getUser() {
		return user;
	}

	public void setUser(LinkedinUser user) {
		this.user = user;
	}
	
}
