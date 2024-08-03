package com.joselucio.springMongocourse;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.repositories.UserRepository;

@DataMongoTest
@DisplayName("Test for User Repository")
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	@DisplayName("Save creates User when sucessful")
	void save_PersistUser_WhenSucessful() {
		LinkedinUser userToBeSaved = createUser();
		LinkedinUser userSaved = this.userRepository.save(userToBeSaved);
		Assertions.assertThat(userSaved).isNotNull();
		Assertions.assertThat(userSaved.getId()).isNotNull();
		Assertions.assertThat(userSaved.getName()).isEqualTo(userToBeSaved.getName());
		
		
	}
	
	private LinkedinUser createUser() {
		LinkedinUser user = new LinkedinUser();
		user.setName("Kyle Walker");
		return user;
	}

}
