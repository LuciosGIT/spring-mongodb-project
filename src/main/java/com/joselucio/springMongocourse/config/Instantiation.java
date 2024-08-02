package com.joselucio.springMongocourse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		LinkedinUser maria = new LinkedinUser(null, "Maria Brown", "maria@gmail.com","marias@git.com");
		LinkedinUser alex = new LinkedinUser(null, "Alex Green", "alex@gmail.com","alex@git.com");
		LinkedinUser bob = new LinkedinUser(null, "Bob Grey", "bob@gmail.com","bob@git.com");
		LinkedinUser miles = new LinkedinUser(null, "Miles Yellow", "miles@gmail.com","miles@git.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob,miles));
		
		
	}
	
}
