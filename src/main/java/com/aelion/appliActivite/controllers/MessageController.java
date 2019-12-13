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
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.dto.MessageFull;
import com.aelion.appliActivite.dto.MessageLight;
import com.aelion.appliActivite.dto.MessagePost;
import com.aelion.appliActivite.exceptions.AppActiArgumentNotValidException;
import com.aelion.appliActivite.persistances.entities.Message;
import com.aelion.appliActivite.services.IAuthChecker;
import com.aelion.appliActivite.services.IMessageService;

/**
 * Class handling the control of Messages
 * 
 * @author Aelion
 *
 */
@RestController
@RequestMapping(path = "/message")
public class MessageController {

	@Autowired
	IMessageService svc;

	@Autowired
	ModelMapper mapper;

	@Autowired
	IAuthChecker authChker;

	@GetMapping
	public List<MessageLight> findAll(){
		return svc.findAll().stream()
				.map(msgL -> mapper.map(msgL, MessageLight.class))
				.collect(Collectors.toList());
	}

	@GetMapping(path = "/{id}")
	public MessageFull findOne(@PathVariable Long id) {
		MessageFull msgF = mapper.map(svc.findOne(id), MessageFull.class);
		return msgF;
	}

	@PostMapping
	public ResponseEntity<String> save (@Valid @RequestBody MessagePost msg) throws AppActiArgumentNotValidException{
		System.out.println(msg);
		if (msg.getReceiverEmail()==null  && msg.getActivityId() == null) {
			ResponseEntity.badRequest();
			throw new AppActiArgumentNotValidException("Message must have a receiver");
		}

		if (msg.getReceiverEmail()!=null && msg.getActivityId()!=null){
			ResponseEntity.badRequest();
			throw new AppActiArgumentNotValidException("Message can't be sent to user AND activity");
		}

		msg.setSendTime(LocalDateTime.now());
		msg.setStatus("send");
		authChker.getCurrentUser();
		Message m =mapper.map(msg, Message.class);
		m.setId(null);
		if (msg.getReceiverEmail()!=null) {
			svc.sendMessageToUser(m,authChker.getCurrentUser().getId(), msg.getReceiverEmail());
			return ResponseEntity.ok("Message has been sent");
		}
		if (msg.getActivityId()!=null) {
			svc.sendMessageToActivity(m,authChker.getCurrentUser().getId(), msg.getActivityId());
			return ResponseEntity.ok("Message has been sent");
		}
		throw new AppActiArgumentNotValidException("I quite don't know what happened !");

	}


	@DeleteMapping("/{id}")
	public boolean deleteById (@PathVariable(name = "id") Long id) {
		return  svc.deleteById(id);
	}

}
