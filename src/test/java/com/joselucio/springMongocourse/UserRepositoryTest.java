package com.joselucio.springMongocourse;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.repositories.UserRepository;
import com.joselucio.springMongocourse.util.UserCreator;

@DataMongoTest
@DisplayName("Test for User Repository")
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	@DisplayName("Save persists User when sucessful")
	void save_PersistUser_WhenSucessful() {
		LinkedinUser userToBeSaved = UserCreator.createUserToBeSaved();
		LinkedinUser userSaved = this.userRepository.save(userToBeSaved);
		
		Assertions.assertThat(userSaved).isNotNull();
		
		Assertions.assertThat(userSaved.getId()).isNotNull();
		
		Assertions.assertThat(userSaved.getName()).isEqualTo(userToBeSaved.getName());
		
		
	}
	
	@Test
	@DisplayName("Save updates User when sucessful")
	void save_UpdatesUser_WhenSucessful() {
		LinkedinUser userToBeSaved = UserCreator.createUserToBeSaved();
		LinkedinUser userSaved = this.userRepository.save(userToBeSaved);
		
		userSaved.setName("Peter Crouch");
		
		LinkedinUser userUpdated = this.userRepository.save(userSaved);
		
		Assertions.assertThat(userUpdated).isNotNull();
		
		Assertions.assertThat(userUpdated.getId()).isNotNull();
		
		Assertions.assertThat(userUpdated.getName()).isEqualTo(userSaved.getName());
		
		
	}
	
	@Test
	@DisplayName("Delete removes User when sucessful")
	void delete_RemovesUser_WhenSucessful() {
		LinkedinUser userToBeSaved = UserCreator.createUserToBeSaved();
		LinkedinUser userSaved = this.userRepository.save(userToBeSaved);
		
		this.userRepository.delete(userSaved);
		
		Optional<LinkedinUser> userOptional = this.userRepository.findById(userSaved.getId());
		
		Assertions.assertThat(userOptional).isEmpty();
	}

	@Test
	@DisplayName("Find By Name returns list of User when sucessful")
	void findByName_ReturnsListOfUser_WhenSucessful() {
		LinkedinUser userToBeSaved = UserCreator.createUserToBeSaved();
		LinkedinUser userSaved = this.userRepository.save(userToBeSaved);
		
		String name = userSaved.getName();
		
		List<LinkedinUser> users = this.userRepository.findByName(name);
		
		Assertions.assertThat(users).isNotEmpty().contains(userSaved);
	}
	

	@Test
	@DisplayName("Find By Name returns empty list when user is not found")
	void findByName_ReturnsEmptyList_WhenUserIsNotFound() {
		
		List<LinkedinUser> users = this.userRepository.findByName("xx");
		
		Assertions.assertThat(users).isEmpty();
		
	}
	

}
