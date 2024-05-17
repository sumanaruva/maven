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

import com.lenskart.dto.CartDTO;
import com.lenskart.dto.UserDTO;
import com.lenskart.entity.Cart;
import com.lenskart.entity.Product;
import com.lenskart.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired // For injecting the Spring Dependencies for invoking getters, setters,
				// constructors etc.
	CustomerServiceImpl userService;

	// User Register
	@PostMapping("/registerUser")
	public UserDTO addUser(@RequestBody UserDTO userDTO) {
		return userService.registerCustomer(userDTO);
	}

	// Read all user
	@GetMapping("/allUsers")
	public List<UserDTO> readAllUsers() {
		return userService.readAllUsers();
	}

	// Update all users
	@PutMapping("/updateUser/{no}")
	public UserDTO updateUser(@PathVariable(value = "no") int no, @RequestBody UserDTO user) {
		userService.updateCustomer(no, user);
		return user;
	}

	// delete users
	@DeleteMapping("/deleteUser/{no}")
	public boolean deleteUser(@PathVariable(value = "no") int no) {
		userService.deleteCustomer(no);
		return true;
	}

	// Read all user
	@GetMapping("/userByEmail/{email}")
	public List<UserDTO> getUserByEmail(@PathVariable(value = "email") String email) {
		return userService.getByEmail(email);
	}

	@GetMapping("/getCart/{custid}")
	public CartDTO getCart(@PathVariable(value = "custid") int custid) {
		return userService.getCartByCustomer(custid);
	}

}
