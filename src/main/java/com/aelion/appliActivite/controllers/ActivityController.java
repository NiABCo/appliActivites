package com.aelion.appliActivite.controllers;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.ActivityFullDTO;
import com.aelion.appliActivite.dto.UserFullDTO;
import com.aelion.appliActivite.exceptions.NotAuthorizedException;
import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.IAuthChecker;
import com.aelion.appliActivite.services.IUserService;
/**
 * Class handling the control of Activities
 * 
 * @author Aelion
 *
 */
@RestController
@RequestMapping(path = "/member/activity")
public class ActivityController {

	@Autowired
	IActivityService activityService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IAuthChecker authChecker;
	
	
	@Autowired
	ModelMapper mapper;

	
	/**
	 * Return the DTO of the user who created this Activity
	 * @param id of the activity
	 * @return The DTO of the user who created this Activity
	 */
	public UserFullDTO getActivityCreator(Long id) {
		
		
		return mapper.map(this.activityService.findOne(id).getCreator(), UserFullDTO.class);
	}

	/**
	 * Return the full DTO of the Activity
	 * @param id of the wanted activity
	 * @return The full DTO of the Activity
	 */
	@GetMapping("/{id}")
	public ActivityFullDTO getActivityById(@PathVariable(name = "id") Long id) {
		
		return mapper.map(this.activityService.findOne(id), ActivityFullDTO.class);
	}

	/**
	 * This allow to save a new Activity in the DB
	 * @param activity NOT a DTO ! Why ?
	 * @return The Activity
	 */
	@PostMapping()
	public Activity saveActivity(@Valid @RequestBody Activity activity) {
		return this.activityService.save(activity);
	}

	/**
	 * This allow to delete a chosen activity from the DB
	 * @param id of the activity to delete
	 * @return true - if the delete was successful<br>
	 * false - if not
	 */
	@DeleteMapping("/{id}")
	public boolean deleteActivityById(@PathVariable(name = "id") Long id) {
		//Vérification de l'user Connecté, si son ID est la même que celui qui a crée l'activity, il pourra la supprimer
		if(this.authChecker.getCurrentUser().getId().equals(this.activityService.findOne(id).getCreator().getId())) {
			return this.activityService.deleteById(id);
			
		}else {
			throw new NotAuthorizedException("You don't have the necessary rights to delete this activity !");
		}
	
		
	}
	
	/**
	 * This allow to add an user as a participant in a given activity
	 * @param id - is the id of the activity in which the user participate in
	 * @param iduser - is the id of the user to add
	 * @return true - if the add was successful<br>
	 * false - if not
	 */
	@PutMapping("/{id}/addusers/{iduser}")
	public boolean addUserToActivity(@PathVariable(name="id")Long id,@PathVariable(name="iduser")Long iduser) {
		
		return activityService.addUserToActivity(id, iduser);
		
		
		
	}
	
	/**
	 * This allow to add the logged user as a participant in a given activity
	 * @param id - is the id of the activity in which the user participate in
	 * @return true - if the add was successful<br>
	 * false - if not
	 */
	@PutMapping("/{id}/adduser")
	public boolean addUserToActivity(@PathVariable(name="id")Long id) {

		return activityService.addUserToActivity(id, this.authChecker.getCurrentUser().getId());
	}



}
