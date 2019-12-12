 package com.aelion.appliActivite;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aelion.appliActivite.persistances.entities.Activity;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IActivityService;
import com.aelion.appliActivite.services.IUserService;

@SpringBootApplication
public class AppliActivitiesApplication implements CommandLineRunner{

	
	@Autowired
	IUserService userService;
	
	@Autowired
	IActivityService activityService;
	
	public static void main(String[] args) {
		SpringApplication.run(AppliActivitiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createUser();
		//createActivity();
	
		
	}
	
	public void createUser() {
		
		
		User newUser = new User();
		
		LocalDate birthday = LocalDate.now();
		
		newUser.setLastname("PINON");
		newUser.setFirstname("Benjamin");
		newUser.setBirthDate(birthday);
		newUser.setDescription("aucune");
		newUser.setNickname("Benji49610");
		newUser.setPassword("$2y$10$M468XrOJwPcLcDE96xbUZuRZ3NBGKrnevYs81BnLNVOrUR21aWGKS");
		newUser.setEmail("ben49.pinon@gmail.com");
		newUser.setRole("ADMIN");
		
		//this.userService.save(newUser);
		
		
		User newUser1 = new User();
		
		LocalDate birthday1 = LocalDate.now();
		
		newUser1.setLastname("LEponge");
		newUser1.setFirstname("Bob");
		newUser1.setBirthDate(birthday1);
		newUser1.setDescription("aucune");
		newUser1.setNickname("Boby");
		newUser1.setPassword("$2y$10$M468XrOJwPcLcDE96xbUZuRZ3NBGKrnevYs81BnLNVOrUR21aWGKS");
		newUser1.setEmail("bob@gmail.com");
		newUser1.setRole("USER");
		
		this.userService.save(newUser1);
	}
	
	public void createActivity(){
		
		User user1 = this.userService.findOne(1L);
	
		
		Activity act = new Activity();
		
		LocalDate createDate = LocalDate.now();
		LocalDate endDate = LocalDate.now().plusDays(5);
		
		
		act.setCreator(user1);
		act.setLabel("Activité au hasard");
		act.setAgeRestricted(false);
		act.setCreationDate(createDate);
		act.setBeginningDate(createDate);
		act.setDescription("aucune description");
		act.setEndingDate(endDate);
		act.setMaxNumber(10);
		act.setPlace("Toulouse City");
		act.setPrice(00.00);

		
		
		activityService.save(act);
		
	}
	
	

}
