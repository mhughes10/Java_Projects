package com.lsb.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserRecordJsonDataLoader implements CommandLineRunner
{

	private static final Logger log = LoggerFactory.getLogger(UserRecordJsonDataLoader.class);
	private final JdbcClientUserList userListI;
	private final ObjectMapper objectMapperI;
	
	public UserRecordJsonDataLoader(JdbcClientUserList userListP, ObjectMapper objectMapperP)
	{
		this.userListI = userListP;
		this.objectMapperI = objectMapperP;
	}
	
	@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		if(userListI.countM() == 0)
		{
			try(InputStream inputStreamP = TypeReference.class.getResourceAsStream("/data/user.json"))
			{
				Users allUsers = objectMapperI.readValue(inputStreamP, Users.class);
				log.info("Reading {} users from JSON data and saving to in-memory collection.", allUsers.users().size());
				userListI.saveAllM(allUsers.users());
			}
			
			catch(IOException e)
			{
				throw new RuntimeException("Failed to read JSON data", e);
			}
		}
		
		else
		{
			log.info("Not loading user from JSON data because the collection contains data");
		}
		
	}

}
