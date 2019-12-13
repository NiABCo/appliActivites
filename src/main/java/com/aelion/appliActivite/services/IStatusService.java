package com.aelion.appliActivite.services;

import com.aelion.appliActivite.persistances.entities.Status;
import com.aelion.appliActivite.services.common.IServiceActions;

public interface IStatusService extends IServiceActions<Status, Long> {

	void saveInAct(Status s, Long idUser, Long idActivity);

}
