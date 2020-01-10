package com.aelion.appliActivite.controllers;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.ActivityFullDTO;
import com.aelion.appliActivite.dto.ActivityLightDTO;
import com.aelion.appliActivite.dto.UserFullDTO;
import com.aelion.appliActivite.exceptions.NotAuthorizedException;
import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.IAuthChecker;
import com.aelion.appliActivite.services.IUserService;
import com.aelion.appliActivite.services.impl.AuthChecker;



@RestController
@RequestMapping(path = "/member/activity")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActivityController {

	@Autowired
	IActivityService activityService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IAuthChecker authChecker;
	
	
	@Autowired
	ModelMapper mapper;

	
	
	
	
	public UserFullDTO getActivityCreator(Long id) {
		
		
		return mapper.map(this.activityService.findOne(id).getCreator(), UserFullDTO.class);
	}

	@GetMapping("/{id}")
	public ActivityFullDTO getActivityById(@PathVariable(name = "id") Long id) {
		System.out.println(id);
		return mapper.map(this.activityService.findOne(id), ActivityFullDTO.class);
	}

	@PostMapping()
	public Activity saveActivity(@Valid @RequestBody Activity activity) {
		return this.activityService.save(activity);
	}

	@DeleteMapping("/{id}")
	public boolean deleteActivityById(@PathVariable(name = "id") Long id) {
		//Vérification de l'user Connecté, si son ID est la même que celui qui a crée l'activity, il pourra la supprimer
		if(this.authChecker.getCurrentUser().getId().equals(this.activityService.findOne(id).getCreator().getId())) {
			return this.activityService.deleteById(id);
			
		}else {
			throw new NotAuthorizedException("You don't have the necessary rights to delete this activity !");
		}
	
		
	}
	
	@PutMapping("/{id}/addusers/{iduser}")
	public boolean addUserToActivity(@PathVariable(name="id")Long id,@PathVariable(name="iduser")Long iduser) {
		
		return activityService.addUserToActivity(id, iduser);
		
		
		
	}
	
	
	@PutMapping("/{id}/adduser")
	public boolean addUserToActivity(@PathVariable(name="id")Long id) {

		return activityService.addUserToActivity(id, this.authChecker.getCurrentUser().getId());
	}



}
