package com.joselucio.springMongocourse.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.entities.Posts;
import com.joselucio.springMongocourse.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public ResponseEntity<Page<LinkedinUser>>findAll(Pageable pageable){
		return ResponseEntity.ok().body(userService.findAll(pageable));
		
}
	@GetMapping(value = "/{id}")
	public ResponseEntity<LinkedinUser> findById(@PathVariable String id){
		LinkedinUser user = userService.findById(id);
		return ResponseEntity.ok().body(user);
}
	@GetMapping(value = "/find")
	public ResponseEntity<List<LinkedinUser>> findByName(@RequestParam String name){
		List<LinkedinUser> list = userService.findByName(name);
		return ResponseEntity.ok().body(list);
}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid LinkedinUser obj){
		userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody LinkedinUser obj, @PathVariable String id){
		obj.setId(id);
		userService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Posts>> findPosts(@PathVariable String id){
		LinkedinUser user = userService.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
}
