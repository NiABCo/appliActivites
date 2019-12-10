package com.aelion.appliActivite.services;

import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.common.IServiceActions;

public interface IUserService extends IServiceActions<User, Long>{

	User findByMail(String email);
	
}
