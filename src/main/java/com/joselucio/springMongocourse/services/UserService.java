package com.joselucio.springMongocourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<LinkedinUser> findAll(){
		List<LinkedinUser> list = userRepository.findAll();
		return list;
	}
	public LinkedinUser findById(String id) {
		Optional<LinkedinUser> user = userRepository.findById(id);
		return user.get();
	}
	
	public void insert(LinkedinUser obj) {
		userRepository.insert(obj);
		
	}
}
