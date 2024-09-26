package com.lsb.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application 
{
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
		
		 HelloWorld phrase = new HelloWorld();
		 System.out.println(phrase.GetWelcomeMessage());
		 log.info("Application has started successfully!");
	}
	
//	@Bean
//	CommandLineRunner runner(UserList userList)
//	{
//		return args -> 
//		{
//			UserRecord user = new UserRecord(1, "sally");
//			//log.info("User: " + user);
//			userList.createM(user);
//		};
//	}

}
