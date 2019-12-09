package com.aelion.appliActivite.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.impl.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired 
	UserService userService;
	
	@GetMapping("/list")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(name = "id") Long id) {
		return userService.findOne(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUserById(@PathVariable(name = "id") Long id) {
		return userService.deleteById(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUserByObject(@PathVariable(name = "id") Long id) {
		User user = getUserById(id);
		return userService.deleteByObject(user);
	}
	
	@PostMapping()
	public User saveUser(@Valid @RequestBody User user) {
	
		return userService.save(user);
	}
	
}
