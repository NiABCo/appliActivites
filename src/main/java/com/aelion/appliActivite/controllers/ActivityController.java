package com.aelion.appliActivite.controllers;

import java.util.List;
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

import com.aelion.appliActivite.dto.ActivityFullDTO;
import com.aelion.appliActivite.dto.ActivityLightDTO;
import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.services.IActivityService;

@RestController
@RequestMapping(path = "/users/activity")
public class ActivityController {

	@Autowired
	IActivityService activityService;
	
	@Autowired
	ModelMapper mapper;

	@GetMapping("/list")
	public List<ActivityLightDTO> getAllActivities() {
		return activityService.findAll().stream().map(activity -> mapper.map(activity, ActivityLightDTO.class)).collect(Collectors.toList());
	}

	@GetMapping("/users/{id}")
	public ActivityFullDTO getActivityById(@PathVariable(name = "id") Long id) {
		return mapper.map(this.activityService.findOne(id), ActivityFullDTO.class);
	}

	@PostMapping("/creator")
	public Activity saveActivity(@Valid @RequestBody Activity activity) {
		return this.activityService.save(activity);
	}

	@DeleteMapping("/creator/{id}")
	public boolean deleteActivityById(@PathVariable(name = "id") Long id) {
		return this.activityService.deleteById(id);
	}



}
