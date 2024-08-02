package com.joselucio.springMongocourse.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joselucio.springMongocourse.entities.Posts;

public interface PostRepository extends MongoRepository<Posts, String>{

}
