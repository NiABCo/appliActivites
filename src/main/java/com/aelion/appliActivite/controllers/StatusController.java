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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.StatusFull;
import com.aelion.appliActivite.dto.StatusLight;
import com.aelion.appliActivite.persistances.entities.Status;
import com.aelion.appliActivite.services.IStatusService;


@RestController
@RequestMapping(path = "/status")
public class StatusController {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	IStatusService serviceStatus;
	
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
	
	@PostMapping
	public StatusFull save(@Valid @RequestBody StatusFull sf) {
		
		Status s = mapper.map(sf,Status.class);
		
		return mapper.map(serviceStatus.save(s),StatusFull.class);
	}
	
}
