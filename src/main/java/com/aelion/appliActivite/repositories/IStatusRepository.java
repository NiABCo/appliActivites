package com.aelion.appliActivite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aelion.appliActivite.persistances.entities.Status;

public interface IStatusRepository extends JpaRepository<Status, Long> {

}
