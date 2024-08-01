package com.joselucio.springMongocourse.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joselucio.springMongocourse.entities.LinkedinUser;

public interface UserRepository extends MongoRepository<LinkedinUser,String> {

}
