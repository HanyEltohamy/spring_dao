package com.bits.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.model.Role;
import com.bits.model.User;
import com.bits.service.RoleService;
import com.bits.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthController {

	private final UserService service;
	private final RoleService roleService;

	@PostMapping("/auth/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.addUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/auth/role/add")
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.addRole(role), HttpStatus.CREATED);
	}
}
