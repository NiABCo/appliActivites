package com.aelion.appliActivite.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.persistances.entities.Activity;

import com.aelion.appliActivite.services.impl.ActivityService;

@RestController
@RequestMapping(path = "/activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;

	@GetMapping("/list")
	public List<Activity> getAllActivities() {
		return activityService.findAll();
	}

	@GetMapping("/{id}")
	public Activity getActivityById(@PathVariable(name = "id") Long id) {
		return this.activityService.findOne(id);
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
