package com.aelion.appliActivite.controllers;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.StatusFull;
import com.aelion.appliActivite.dto.StatusLight;
import com.aelion.appliActivite.dto.StatusPost;
import com.aelion.appliActivite.persistances.entities.Status;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.IStatusService;

/**
 * Class handling the control of Status
 * 
 * @author Aelion
 *
 */
@RestController
@RequestMapping(path = "/status")
public class StatusController {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	IStatusService serviceStatus;
	
	@Autowired
	IActivityService actSvc;
	
	public StatusController() {
		
	}
	
	@RequestMapping (path = "/list",method = RequestMethod.GET)
	public List<StatusLight> findAll(){
		
		return serviceStatus.findAll()
				.stream()
				.map(c -> mapper.map(c,StatusLight.class))
				.collect(Collectors.toList());
		
	}
	
	@GetMapping(path ="/{identifiant}")
	public StatusFull findOne (@PathVariable(name= "identifiant") Long id) {
		
		return mapper.map(serviceStatus.findOne(id),StatusFull.class);
		
	}
	
	@DeleteMapping(path ="/{id}")
	public Boolean deleteOne (@PathVariable Long id) {
		
			serviceStatus.findOne(id);
		
			return serviceStatus.deleteById(id);
			
	}
	
//	@PostMapping(path="/updstatus")
//	public ResponseEntity<String> saveInAct(@Valid @RequestBody StatusPost statusPost) {
//		
//		
//		
//		Status s = mapper.map(statusPost,Status.class);
//		s.setDate(LocalDateTime.now());
//		serviceStatus.saveInAct(s, statusPost.getIdUser(), statusPost.getIdActivity());
//		return ResponseEntity.ok("Status Updated");
//	}
	
	@PostMapping(path = "/newstatus")
	public  ResponseEntity<String> addNewUsrToAct(@Valid @RequestBody StatusPost statusPost) {
		
		Status s = mapper.map(statusPost,Status.class);
		s.setDate(LocalDateTime.now());
		
		actSvc.addUserToActivity(statusPost.getIdActivity(), statusPost.getIdUser());
		
		serviceStatus.saveInAct(s, statusPost.getIdUser(), statusPost.getIdActivity());
		
		return ResponseEntity.ok("Status Updated");
	}
	
}
