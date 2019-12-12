package com.aelion.appliActivite.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.persistances.entities.ActivityHasUser;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.persistances.repositories.IActivityRepository;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.IUserService;
import com.aelion.appliActivite.services.common.AbstractService;

@Service
@Transactional
public class ActivityService extends AbstractService<Activity, Long> implements IActivityService {


	@Autowired
	IActivityRepository activityRepo;
	
	@Autowired
	IUserService userService;
	
	@Override
	public JpaRepository<Activity, Long> getRepo() {
		return activityRepo;
	}

	@Override
	public boolean addUserToActivity(Long id,Long idUser) {
		Activity activityToUpdate = getRepo().getOne(id);
		User user = this.userService.findOne(idUser);
		
		
		if(activityToUpdate != null) {
			
			ActivityHasUser newActHasUser = new ActivityHasUser();
			Set<ActivityHasUser> listActHasUser = new HashSet<ActivityHasUser>();
			
			newActHasUser.setUser(user);
			
			listActHasUser.add(newActHasUser);
			activityToUpdate.setActHasUser(listActHasUser);
			
			this.getRepo().save(activityToUpdate);
			
			return true;
		}else {
			return false;
		}
	}

}
