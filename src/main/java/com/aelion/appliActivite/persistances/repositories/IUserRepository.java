package com.aelion.appliActivite.persistances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aelion.appliActivite.persistances.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	@Query(nativeQuery = true,value = ""
			+ "SELECT * "
			+ "FROM users "
			+ "WHERE email = ?1 LIMIT 0,1")
	User findByMail(String email);

}
