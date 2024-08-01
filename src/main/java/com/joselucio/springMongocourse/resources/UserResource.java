package com.joselucio.springMongocourse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<LinkedinUser>>findAll(){
		List<LinkedinUser> list = userService.findAll();
		return ResponseEntity.ok().body(list);
		
}
	@GetMapping(value = "/{id}")
	public ResponseEntity<LinkedinUser> findById(@PathVariable String id){
		LinkedinUser user = userService.findById(id);
		return ResponseEntity.ok().body(user);
}
	
}
