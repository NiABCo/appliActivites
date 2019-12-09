package com.aelion.appliActivite.persistances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelion.appliActivite.persistances.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}
