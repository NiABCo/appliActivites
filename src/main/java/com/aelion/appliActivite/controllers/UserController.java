package com.aelion.appliActivite.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.UserFullDTO;
import com.aelion.appliActivite.dto.UserLightDTO;
import com.aelion.appliActivite.dto.UserPost;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IUserService;

/**
 * Class handling the control of Users
 * 
 * @author Aelion
 *
 */
@RestController
@RequestMapping(path = "/admin/user")
public class UserController {

	@Autowired 
	IUserService userService;
	
	@Autowired
	ModelMapper mapper;
	
	
	/**
	 * Return the list of all users
	 * 
	 * @return The list of DTO of the users
	 */
	
	@GetMapping("/list")
	public List<UserLightDTO> getAllUsers(){
		return userService.findAll().stream().map(user -> mapper.map(user, UserLightDTO.class)).collect(Collectors.toList());
	}
	
	/**
	 * Return the user with this id "id"
	 * 
	 * @param id of the user to return
	 * @return The DTO of the user with the given id
	 */
	@GetMapping("/{id}")
	public UserFullDTO getUserById(@PathVariable(name = "id") Long id) {
		return mapper.map(userService.findOne(id), UserFullDTO.class) ;
	}
	
	/**
	 * Remove a User from the Database
	 * 
	 * @param id : id of the user to delete from the DB
	 * @return true if successful, false if not.
	 */
	@DeleteMapping("/{id}")
	public boolean deleteUserById(@PathVariable(name = "id") Long id) {
		return  userService.deleteById(id);
	}
	
	/**
	 * Save a new user to the Database with a Post
	 * 
	 * @param userP Request Body of the request. Must be an UserPost
	 * @return Reponse send to the front
	 */
	@PostMapping()
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserPost userP) {
		User user = mapper.map(userP, User.class);
		userService.saveUser(user);
		return ResponseEntity.ok("User has been added");
	}
	
}
