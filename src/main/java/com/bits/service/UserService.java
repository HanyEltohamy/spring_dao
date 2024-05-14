package com.bits.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bits.model.Role;
import com.bits.model.User;
import com.bits.repository.RoleRepository;
import com.bits.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;

	@Transactional
	public User addUser(User user) {
		Set<Role> roles = user.getRoles().stream().map(role -> {
			Role foundRole = roleRepository.findById(role.getId()).orElseThrow();
			foundRole.getUsers().add(user);
			return foundRole;
		}).collect(Collectors.toSet());
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	public User findByname(String userName) {
		return repository.findByName(userName).orElseThrow();
	}
}
