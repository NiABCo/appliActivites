package com.aelion.appliActivite.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.MessageFull;
import com.aelion.appliActivite.dto.MessageLight;
import com.aelion.appliActivite.dto.MessagePost;
import com.aelion.appliActivite.persistances.entities.Message;
import com.aelion.appliActivite.services.IMessageService;

@RestController
@RequestMapping(path = "/message")
public class MessageController {
	
	@Autowired
	IMessageService svc;
	
	@Autowired
	ModelMapper mapper;

	@GetMapping
	public List<MessageLight> findAll(){
		return svc.findAll().stream()
				.map(msgL -> mapper.map(msgL, MessageLight.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping(path = "/{id}")
	public MessageFull findOne(@PathVariable Long id) {
		MessageFull msgF = mapper.map(svc.findOne(id), MessageFull.class);
		//TODO add sender && receiver
		return msgF;
	}
	
	@PostMapping
	public ResponseEntity<String> save (@Valid @RequestBody MessagePost msg){
		svc.save(mapper.map(msg, Message.class));
		return ResponseEntity.ok("Command has been added");
	}
	
	
}
