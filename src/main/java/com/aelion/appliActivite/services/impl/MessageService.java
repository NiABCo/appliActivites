package com.aelion.appliActivite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.persistances.entities.Message;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.persistances.repositories.IMessageRepository;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.IMessageService;
import com.aelion.appliActivite.services.IUserService;
import com.aelion.appliActivite.services.common.AbstractService;

@Service
@Transactional
public class MessageService extends AbstractService<Message, Long> implements IMessageService{

	@Autowired
	IMessageRepository repo;
	
	@Autowired
	IUserService usrSvc;
	
	@Autowired
	IActivityService actSvc;
	
	@Override
	public JpaRepository<Message, Long> getRepo() {
		return this.repo;
	}

	@Override
	public void sendMessageToUser(Message message, Long idSender, String email) {		
		User receiver = usrSvc.findByMail(email);		
		message.setReceiverUsr(receiver);
		
		User sender = usrSvc.findOne(idSender);
		sender.getSendMsg().add(message);
		
		usrSvc.save(sender);
	}
	
	@Override
	public void sendMessageToActivity(Message message, Long idSender, Long id) {		
		Activity receiver = actSvc.findOne(id);		
		message.setReceiverAct(receiver);
		
		User sender = usrSvc.findOne(idSender);
		sender.getSendMsg().add(message);
		
		usrSvc.save(sender);
	}

}
