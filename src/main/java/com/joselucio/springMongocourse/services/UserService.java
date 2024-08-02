package com.joselucio.springMongocourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.exceptions.ObjectNotFoundException;
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
		return user.orElseThrow(() -> new ObjectNotFoundException("Object Not Found!"));
	}
	
	public void insert(LinkedinUser obj) {
		userRepository.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
 
	public LinkedinUser update(LinkedinUser obj) {
		Optional<LinkedinUser> newObj = userRepository.findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj.get());
	}
	
	private void updateData(Optional<LinkedinUser> newObj, LinkedinUser obj) {
		newObj.get().setName(obj.getName());
		newObj.get().setEmail(obj.getEmail());
		newObj.get().setGithub(obj.getGithub());
		
	}
}
