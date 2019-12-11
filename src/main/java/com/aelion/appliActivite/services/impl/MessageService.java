package com.aelion.appliActivite.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.persistances.entities.Message;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.persistances.repositories.IMessageRepository;
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
	
	@Override
	public JpaRepository<Message, Long> getRepo() {
		return this.repo;
	}

	@Override
	public void sendMessage(Message message, Long idSender) {
		User sender = usrSvc.findOne(idSender);
		List<Message> messageList = sender.getSendMsg();
		messageList.add(message);
		sender.setSendMsg(messageList);
		repo.save(message);
	}

}
