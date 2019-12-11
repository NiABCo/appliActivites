package com.aelion.appliActivite.services;

import com.aelion.appliActivite.persistances.entities.Message;
import com.aelion.appliActivite.services.common.IServiceActions;

public interface IMessageService extends IServiceActions<Message, Long> {

	void sendMessageToUser(Message map, Long idSender, String email);
	
	void sendMessageToActivity(Message map, Long idSender, Long id);

}
