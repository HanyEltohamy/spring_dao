package com.bits.service;

import org.springframework.stereotype.Service;

import com.bits.model.Role;
import com.bits.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {

	private final RoleRepository roleRepository;

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	public Role getRoleByid(Long id) {
		return roleRepository.findById(id).orElseThrow();
	}

}
