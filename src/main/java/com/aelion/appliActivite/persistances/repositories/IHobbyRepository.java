package com.aelion.appliActivite.persistances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelion.appliActivite.persistances.entities.Hobby;

@Repository
public interface IHobbyRepository extends JpaRepository<Hobby, Long> {

}
