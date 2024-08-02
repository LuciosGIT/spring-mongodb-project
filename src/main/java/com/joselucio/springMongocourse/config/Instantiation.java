package com.joselucio.springMongocourse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joselucio.springMongocourse.entities.Comments;
import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.entities.Posts;
import com.joselucio.springMongocourse.repositories.PostRepository;
import com.joselucio.springMongocourse.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		
		LinkedinUser maria = new LinkedinUser(null, "Maria Brown", "maria@gmail.com","marias@git.com");
		LinkedinUser alex = new LinkedinUser(null, "Alex Green", "alex@gmail.com","alex@git.com");
		LinkedinUser bob = new LinkedinUser(null, "Bob Grey", "bob@gmail.com","bob@git.com");
		LinkedinUser miles = new LinkedinUser(null, "Miles Yellow", "miles@gmail.com","miles@git.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,miles));
		
		Posts p1 = new Posts(null, "Good morning, have a great day!", maria);
		Posts p2 = new Posts(null, "Enjoy your trip!", bob);
		Posts p3 = new Posts(null, "That's awesome!", miles);
		
		postRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Comments c1 = new Comments("Wow, well done!", bob);
		Comments c2 = new Comments("Great job!", miles);
		
		maria.getPosts().add(p1);
		bob.getPosts().add(p2);
		miles.getPosts().add(p3);
		
		p1.getComments().add(c1);
		p3.getComments().add(c2);
		
		userRepository.saveAll(Arrays.asList(maria,bob,miles));
		postRepository.saveAll(Arrays.asList(p1,p3));
		
	}
	
}
