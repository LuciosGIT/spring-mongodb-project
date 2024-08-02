package com.joselucio.springMongocourse.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joselucio.springMongocourse.entities.Posts;
import com.joselucio.springMongocourse.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	
	@Autowired
	PostService postService;
	
	public ResponseEntity<Posts> findById(@PathVariable String id){
		Posts post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
}
