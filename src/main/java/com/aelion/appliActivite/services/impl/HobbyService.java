package com.aelion.appliActivite.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aelion.appliActivite.persistances.entities.Hobby;
import com.aelion.appliActivite.services.common.AbstractService;
import com.aelion.appliActivite.persistances.repositories.IHobbyRepository;
import com.aelion.appliActivite.services.IHobbyService;

@Service
@Transactional
public class HobbyService extends AbstractService<Hobby, Long> implements IHobbyService{

	@Autowired
	private IHobbyRepository repo;
	
	@Override
	public JpaRepository<Hobby, Long> getRepo() {
		
		return this.repo;
		
	}

}
