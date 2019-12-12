package com.aelion.appliActivite.services;

import javax.validation.Valid;

import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.common.IServiceActions;

public interface IActivityService extends IServiceActions<Activity, Long> {

	boolean addUserToActivity(Long id, Long idUser);

	

}
