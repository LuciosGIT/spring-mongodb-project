package com.joselucio.springMongocourse.util;

import com.joselucio.springMongocourse.entities.LinkedinUser;

public class UserCreator {
	public static LinkedinUser createUserToBeSaved() {
		LinkedinUser user = new LinkedinUser();
		user.setName("Jason Momoa");
		return user;
	}
	
	public static LinkedinUser createValidUser() {
		LinkedinUser user = new LinkedinUser();
		user.setName("Jason Momoa");
		user.setId("akkmsk");
		return user;
	}
	
	public static LinkedinUser createValidUpdatedUser() {
		LinkedinUser user = new LinkedinUser();
		user.setId("akkmsk");
		user.setName("Jason Kidd");
		return user;
	}
}
