package com.lenskart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenskart.dto.UserDTO;
import com.lenskart.serviceimpl.AdminServiceImpl;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired // For injecting the Spring Dependencies for invoking getters, setters,
				// constructors etc.
	AdminServiceImpl adminServiceImpl;

	// User Register
	@PostMapping("/registerAdmin")
	public UserDTO addAdmin(@RequestBody UserDTO adminDTO) {
		return adminServiceImpl.addAdmin(adminDTO);
	}

	// Update all users
	@PutMapping("/updateAdmin/{no}")
	public UserDTO updateAdmin(@PathVariable(value = "no") int no, @RequestBody UserDTO admin) {
		adminServiceImpl.updateAdmin(no, admin);
		return admin;
	}

	// Read all user
	@GetMapping("/adminByEmail/{email}")
	public List<UserDTO> getAdminByEmail(@PathVariable(value = "email") String email) {
		return adminServiceImpl.getAdminByEmail(email);
	}

}
