package com.ishak.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishak.app.entity.HomeInfo;
import com.ishak.app.repository.HomeRepository;

@Service
public class HomeInfoService {

	@Autowired
	private HomeRepository homeRepository;

	public HomeInfo homeInfoAll() {
		List<HomeInfo>  homeInfos=  (List<HomeInfo>) homeRepository.findAllById(1L);
		return homeInfos.get(0);
	}

}