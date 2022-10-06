package com.ishak.app.model;

import java.io.Serializable;

import com.ishak.app.entity.User;

public class RegistrationUser extends User implements Serializable {

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}