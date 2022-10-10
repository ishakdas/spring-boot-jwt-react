package com.ishak.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishak.app.dto.LoginDto;
import com.ishak.app.entity.HomeInfo;
import com.ishak.app.service.HomeInfoService;

@RestController
public class HomeController {
	@Autowired
	private HomeInfoService homeInfoService;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ResponseEntity<?> homeInfo1() throws Exception {
		try {
			HomeInfo homeInfo = homeInfoService.homeInfoAll();
			return ResponseEntity.ok(homeInfo);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}
}
