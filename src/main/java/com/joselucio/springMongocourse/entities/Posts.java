package com.joselucio.springMongocourse.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Posts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String message;
	
	@JsonIgnore
	private LinkedinUser poster;
	
	private List<Comments> comments = new ArrayList<>();
	
	public Posts() {
		
	}

	public Posts(String id, String message, LinkedinUser poster) {
		super();
		this.id = id;
		this.message = message;
		this.poster = poster;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LinkedinUser getPoster() {
		return poster;
	}

	public void setPoster(LinkedinUser poster) {
		this.poster = poster;
	}
	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posts other = (Posts) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
