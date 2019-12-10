package com.aelion.appliActivite.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.config.Converter;
import com.aelion.appliActivite.dto.UserFullDTO;
import com.aelion.appliActivite.dto.UserLightDTO;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IUserService;
import com.aelion.appliActivite.services.impl.UserService;


@RestController
@RequestMapping(path = "/users/user")
public class UserController {

	@Autowired 
	IUserService userService;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping("/list")
	public List<UserLightDTO> getAllUsers(){
		return userService.findAll().stream().map(user -> mapper.map(user, UserLightDTO.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/admin/{id}")
	public UserFullDTO getUserById(@PathVariable(name = "id") Long id) {
		return mapper.map(userService.findOne(id), UserFullDTO.class) ;
	}
	
	@DeleteMapping("/admin/{id}")
	public boolean deleteUserById(@PathVariable(name = "id") Long id) {
		return  userService.deleteById(id);
	}
	
	@DeleteMapping("/admin/{id}")
	public boolean deleteUserByObject(@PathVariable(name = "id") Long id) {
		User user = userService.findOne(id);
		return userService.deleteByObject(user);
	}
	
	@PostMapping()
	public User saveUser(@Valid @RequestBody User user) {
	
		return userService.save(user);
	}
	
}
