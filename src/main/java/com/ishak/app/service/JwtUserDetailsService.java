package com.ishak.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ishak.app.dto.LoginDto;
import com.ishak.app.entity.User;
import com.ishak.app.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userDao.findByUserName(userName);
		;
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPasswordHash(),
				new ArrayList<>());
	}

	public String save(LoginDto user) {
		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPasswordHash(passwordEncoder().encode(user.getPassword()));
		userDao.save(newUser); 
		return newUser.getUserName();
	}
}