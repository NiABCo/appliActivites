package com.aelion.appliActivite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aelion.appliActivite.persistances.entities.Message;
import com.aelion.appliActivite.persistances.repositories.IMessageRepository;
import com.aelion.appliActivite.services.IMessageService;
import com.aelion.appliActivite.services.common.AbstractService;

public class MessageService extends AbstractService<Message, Long> implements IMessageService{

	@Autowired
	IMessageRepository repo;
	
	@Override
	public JpaRepository<Message, Long> getRepo() {
		return this.repo;
	}

}
