package com.aelion.appliActivite.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.exceptions.NotFoundException;
import com.aelion.appliActivite.persistances.entities.ActivityHasUser;
import com.aelion.appliActivite.persistances.entities.Status;
import com.aelion.appliActivite.persistances.repositories.IActivityHasUserRepository;
import com.aelion.appliActivite.persistances.repositories.IStatusRepository;

import com.aelion.appliActivite.services.IStatusService;
import com.aelion.appliActivite.services.common.AbstractService;

@Service
@Transactional
public class StatusService extends AbstractService<Status, Long> implements IStatusService {

	@Autowired
	private IStatusRepository repo;
	
	@Autowired
	private IActivityHasUserRepository actHasUsrRepo;
	
	@Override
	public JpaRepository<Status, Long> getRepo() {
		
		return this.repo;
		
	}

	@Override
	public void saveInAct(Status s, Long idUser, Long idActivity) {
		
		ActivityHasUser aHU = actHasUsrRepo.findByActAndUsr(idUser,idActivity);
		
		if (aHU == null) {
			throw new NotFoundException();
		}
		
		if (aHU.getStatus() == null) {
			aHU.setStatus(new ArrayList<Status>());
		}
			
		aHU.getStatus().add(s);
		actHasUsrRepo.save(aHU);
	}
}
