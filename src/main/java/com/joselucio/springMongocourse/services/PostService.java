package com.joselucio.springMongocourse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselucio.springMongocourse.entities.Posts;
import com.joselucio.springMongocourse.exceptions.ObjectNotFoundException;
import com.joselucio.springMongocourse.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Posts findById(String id){
		Optional<Posts> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Post Not Found!"));
	}
	
}
