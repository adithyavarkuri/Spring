package com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.User;
import com.repo.UserRepo;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	
	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
	
	@Override
	 public void run(String... args) throws Exception {
	        User user=new User(1,"Adithya" , "adithya.varkuri");
	        userRepo.save(user);
	        User userInfo=userRepo.findById(1).get();
	        userRepo.deleteById(1);
	     
	        System.out.print(userInfo.getUserId()+" "+userInfo.getUserName());
	        
	    }

}
