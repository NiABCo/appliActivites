package com.aelion.appliActivite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aelion.appliActivite.persistances.entities.ActivityHasUser;

public interface IActivityHasUserRepository extends JpaRepository<ActivityHasUser, Long>{

}
