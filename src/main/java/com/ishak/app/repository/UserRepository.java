package com.ishak.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ishak.app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUserName(String userName);
}