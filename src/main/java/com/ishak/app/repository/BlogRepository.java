package com.ishak.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ishak.app.entity.HomeInfo;
import com.ishak.app.entity.Post;

@Repository
public interface BlogRepository extends CrudRepository<Post, Integer> {
	List<Post> findAll();
}