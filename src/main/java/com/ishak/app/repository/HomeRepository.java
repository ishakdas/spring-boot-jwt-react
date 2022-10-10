package com.ishak.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ishak.app.entity.HomeInfo;

@Repository
public interface HomeRepository extends CrudRepository<HomeInfo, Integer> {
	List<HomeInfo> findAllById(Long id);
}