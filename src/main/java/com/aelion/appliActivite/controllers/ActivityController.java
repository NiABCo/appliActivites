package com.aelion.appliActivite.controllers;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.ActivityFullDTO;
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
		
		return mapper.map(this.activityService.findOne(id), ActivityFullDTO.class);
	}

	@PostMapping()
	public Activity saveActivity(@Valid @RequestBody Activity activity) {
		return this.activityService.save(activity);
	}

	@DeleteMapping("/{id}")
	public boolean deleteActivityById(@PathVariable(name = "id") Long id) {
		
		if(this.authChecker.getCurrentUser().getId().equals(this.activityService.findOne(id).getCreator().getId())) {
			return this.activityService.deleteById(id);
			
		}else {
			throw new NotAuthorizedException("You don't have the necessary rights to delete this activity !");
		}
	
		
	}



}
