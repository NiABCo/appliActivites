package com.aelion.appliActivite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aelion.appliActivite.persistances.entities.Status;
import com.aelion.appliActivite.repositories.IStatusRepository;
import com.aelion.appliActivite.services.IStatusService;
import com.aelion.appliActivite.services.common.AbstractService;

public class StatusService extends AbstractService<Status, Long> implements IStatusService {

	@Autowired
	private IStatusRepository repo;
	
	@Override
	public JpaRepository<Status, Long> getRepo() {
		
		return this.repo;
		
	}
}
