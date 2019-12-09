package com.aelion.appliActivite.persistances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelion.appliActivite.persistances.entities.Activity;

@Repository
public interface IActivityRepository extends JpaRepository<Activity, Long> {

}
