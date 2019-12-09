package com.aelion.appliActivite.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.config.Converter;
import com.aelion.appliActivite.dto.ActivityFullDTO;
import com.aelion.appliActivite.dto.ActivityLightDTO;
import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.services.IActivityService;

@RestController
@RequestMapping(path = "/activity")
public class ActivityController {

	@Autowired
	IActivityService activityService;
	
	@Autowired
	Converter modelMap;

	@GetMapping("/list")
	public List<ActivityLightDTO> getAllActivities() {
		return activityService.findAll().stream().map(activity -> modelMap.initMapper().map(activity, ActivityLightDTO.class)).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ActivityFullDTO getActivityById(@PathVariable(name = "id") Long id) {
		return modelMap.initMapper().map(this.activityService.findOne(id), ActivityFullDTO.class);
	}

	@PostMapping()
	public Activity saveActivity(@Valid @RequestBody Activity activity) {
		return this.activityService.save(activity);
	}

	@DeleteMapping("/{id}")
	public boolean deleteActivityById(@PathVariable(name = "id") Long id) {
		return this.activityService.deleteById(id);
	}

	@DeleteMapping("/{id}")
	public boolean deleteActivityByObject(@PathVariable(name = "id") Long id) {
		Activity activity = this.activityService.findOne(id);

		return this.activityService.deleteByObject(activity);

	}

}
