package com.bits.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/emp/all")
	public String getAllEmployeees() {
		return "All Employees";
	}

	@GetMapping("/emp/admin")
//	@PreAuthorize("hasAuthority('ADMIN')")
	@Secured("ROLE_ADMIN") 
//	@PreAuthorize("hasRole('ADMIN')")
	public String adminOnly() {
		return "This is Admin Employee";
	}
}
