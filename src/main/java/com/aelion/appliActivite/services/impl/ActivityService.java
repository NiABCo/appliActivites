package com.aelion.appliActivite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.persistances.repositories.IActivityRepository;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.common.AbstractService;

@Service
@Transactional
public class ActivityService extends AbstractService<Activity, Long> implements IActivityService {


	@Autowired
	IActivityRepository activityRepo;
	
	@Override
	public JpaRepository<Activity, Long> getRepo() {
		return activityRepo;
	}

}
