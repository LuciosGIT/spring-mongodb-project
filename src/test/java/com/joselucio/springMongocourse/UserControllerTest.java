package com.joselucio.springMongocourse;



import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joselucio.springMongocourse.entities.LinkedinUser;
import com.joselucio.springMongocourse.exceptions.ObjectNotFoundException;
import com.joselucio.springMongocourse.resources.UserResource;
import com.joselucio.springMongocourse.services.UserService;
import com.joselucio.springMongocourse.util.UserCreator;





@ExtendWith(SpringExtension.class)
class UserControllerTest {
	
	@InjectMocks
	UserResource userResource;
	
	@Mock
	UserService userService;
	
	@BeforeEach
	void setUp() {
		
		LinkedinUser userCreated = UserCreator.createValidUser();
		
		Mockito.when(userService.findById(ArgumentMatchers.any())).thenReturn(userCreated);
		
		Mockito.when(userService.findByName(ArgumentMatchers.any())).thenReturn(List.of(userCreated));
		
		Mockito.when(userService.findById("akkmsk")).thenThrow(new ObjectNotFoundException("User not found!"));
	}
	
	@Test
	@DisplayName("findById method returns LinkedinUser")
	void findByIdReturnsUser() {
		LinkedinUser user = new LinkedinUser();
		user.setId("wkfmqkmq");
		Mockito.when(userService.findById(user.getId())).thenReturn(user);
		String idExpected = "wkfmqkmq";
		
		LinkedinUser userTested = userResource.findById(idExpected).getBody();
		
		//Verifying if user class is LinkedinUser
		Assertions.assertEquals(LinkedinUser.class, userTested.getClass());
		
		//Verifying if user Id is equal to expectedId
		Assertions.assertEquals(idExpected, userTested.getId());
		
		//Verifying if user is not null
		Assertions.assertNotNull(userTested);
	}
	
	@Test
	@DisplayName("findByName method returns list of users")
	void findByNameReturnsListOfUser() {
		String nameExpected = "Jason Momoa";
		List<LinkedinUser> user = userResource.findByName("Jason Momoa").getBody();
		
		//Verifying if user class is LinkedinUser
		Assertions.assertEquals(LinkedinUser.class, user.get(0).getClass());
		
		//Verifying if user Name is equal to expectedName
		Assertions.assertEquals(nameExpected, user.get(0).getName());
		
		//Verifying if user is not null
		Assertions.assertNotNull(user);
		
		//Verifying if user List is of size 1
		Assertions.assertEquals(user.size(), 1);
		
	}
	@Test
	@DisplayName("findById method throws ObjectNotFoundException when user's not found")
	void findByIdThrowsObjectNotFoundExceptionWhenUsersNotFound() {
		
		String fakeId = "akkmsk";
		
		//Verifying if method throws ObjectNotFoundException when user's not found
		
		Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            userResource.findById(fakeId);
        });
		
		
	}
	

}
	