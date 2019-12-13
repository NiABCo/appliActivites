package com.aelion.appliActivite.persistances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aelion.appliActivite.persistances.entities.ActivityHasUser;

public interface IActivityHasUserRepository extends JpaRepository<ActivityHasUser, Long>{

	@Query(nativeQuery = true,value = ""
			+ "SELECT * "
			+ "FROM activity_has_user "
			+ "WHERE activity_has_user.id_user = ?1 AND activity_has_user.id_act = ?2 "
			+ "LIMIT 0,1")
	ActivityHasUser findByActAndUsr(Long idUser, Long idActivity);

}
