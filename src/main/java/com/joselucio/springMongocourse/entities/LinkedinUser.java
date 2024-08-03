package com.joselucio.springMongocourse.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document
public class LinkedinUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotBlank(message = "The field might be filled with some user")
	private String name;
	private String email;
	private String github;
	
	@DBRef(lazy = true)
	private List<Posts> posts = new ArrayList<>();
	
	public LinkedinUser() {
		
	}

	public LinkedinUser(String id, String name, String email, String github) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.github = github;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}
	
	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
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
		LinkedinUser other = (LinkedinUser) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
