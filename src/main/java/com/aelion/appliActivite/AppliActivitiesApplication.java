


 package com.aelion.appliActivite;


import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aelion.appliActivite.persistances.entities.User;
import com.aelion.appliActivite.services.IUserService;

@SpringBootApplication
public class AppliActivitiesApplication implements CommandLineRunner{

	@Autowired
	IUserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AppliActivitiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		//createUser();
	}

	public void createUser() {

		LocalDate birthDate = LocalDate.now();

		User user = new User();
		user.setLastname("Wayne");
		user.setFirstname("Bruce");
		user.setBirthDate(birthDate);
		user.setDescription("héros justicier");
		user.setNickname("Le Chevalier Noir");
		user.setPassword("taliaAlGhul");
		user.setEmail("batMail@savetheworld.us");
		userService.save(user);

		
		
		User newUser = new User();
		
		LocalDate birthday = LocalDate.now();
		
		newUser.setLastname("PINON");
		newUser.setFirstname("Benjamin");
		newUser.setBirthDate(birthday);
		newUser.setDescription("aucune");
		newUser.setNickname("Benji49610");
		newUser.setPassword("$2y$10$M468XrOJwPcLcDE96xbUZuRZ3NBGKrnevYs81BnLNVOrUR21aWGKS");
		newUser.setEmail("ben49.pinon@gmail.com");
		this.userService.save(newUser);

	}

}
