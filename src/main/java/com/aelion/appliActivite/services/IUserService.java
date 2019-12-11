package com.aelion.appliActivite.services;

import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.common.IServiceActions;


@Transactional
public interface IUserService extends IServiceActions<User, Long>{


	User findByMail(String email);
	
	User saveUser(User user);

	
}
