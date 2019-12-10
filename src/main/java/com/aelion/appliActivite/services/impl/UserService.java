package com.aelion.appliActivite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.persistances.repositories.IUserRepository;
import com.aelion.appliActivite.services.IUserService;
import com.aelion.appliActivite.services.common.AbstractService;

@Service
@Transactional
public class UserService extends AbstractService<User, Long> implements IUserService{

	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public JpaRepository<User, Long> getRepo() {
		return userRepository;
	}

	@Override
	public User findByMail(String email) {


		return this.userRepository.findByMail(email);
	}

}
