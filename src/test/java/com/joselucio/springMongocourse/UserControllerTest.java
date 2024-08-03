package com.joselucio.springMongocourse;



import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.resources.UserResource;
import com.joselucio.springMongocourse.services.UserService;
import com.joselucio.springMongocourse.util.UserCreator;

@ExtendWith(SpringExtension.class)
class UserControllerTest {
	
	@InjectMocks
	private UserResource userResource;
	
	@Mock
	private UserService userServiceMock;
	
	@BeforeEach
	void setUp() {
		PageImpl<LinkedinUser> userPage = new PageImpl<>(List.of(UserCreator.createValidUser()));
		BDDMockito.when(userServiceMock.findAll(ArgumentMatchers.any()))
		.thenReturn(userPage);
	}
	@Test
	@DisplayName("List Returns list of users inside page object when successful")
	void list_ReturnsListOfUsersInsidePageObject_WhenSuccessful() {
		String expectedName = UserCreator.createValidUser().getName();
		
		Page<LinkedinUser> userPage = userResource.findAll(null).getBody();
		
		Assertions.assertThat(userPage).isNotNull();
		
		Assertions.assertThat(userPage.toList()).isNotEmpty().hasSize(1);
		
		Assertions.assertThat(userPage.toList().get(0).getName()).isEqualTo(expectedName);
	}

}
