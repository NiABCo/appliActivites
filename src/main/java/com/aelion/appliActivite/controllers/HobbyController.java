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

import com.aelion.appliActivite.dto.HobbyFull;
import com.aelion.appliActivite.dto.HobbyLight;

import com.aelion.appliActivite.persistances.entities.Hobby;

import com.aelion.appliActivite.services.IHobbyService;


@RestController
@RequestMapping(path = "/hobby")
public class HobbyController {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	IHobbyService serviceHobby;
	
	public HobbyController() {
		
	}
	
	@RequestMapping (path = "/",method = RequestMethod.GET)
	public List<HobbyLight> findAll(){
		
		return serviceHobby.findAll()
				.stream()
				.map(c -> mapper.map(c,HobbyLight.class))
				.collect(Collectors.toList());
		
	}
	
	@GetMapping(path ="/{identifiant}")
	public HobbyFull findOne (@PathVariable(name= "identifiant") Long id) {
		
		return mapper.map(serviceHobby.findOne(id),HobbyFull.class);
		
	}
	
	@DeleteMapping(path ="/{id}")
	public Boolean deleteOne (@PathVariable Long id) {
		
			serviceHobby.findOne(id);
			
			return serviceHobby.deleteById(id);
			
	}
	
	@PostMapping
	public HobbyFull save(@Valid @RequestBody HobbyFull hf) {
		
		Hobby h = mapper.map(hf,Hobby.class);
		
		return mapper.map(serviceHobby.save(h),HobbyFull.class);
	}
}
