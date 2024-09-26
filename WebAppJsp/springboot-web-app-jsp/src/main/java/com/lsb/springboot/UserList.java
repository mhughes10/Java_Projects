package com.lsb.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class UserList
{
	List<User> userL = new ArrayList<>();
	
	@PostConstruct
	private void AddUser()
	{
		//User newUser = new User(1,"sally");
		userL.add(new User(1,"Sally"));
		userL.add(new User(2,"Billy"));
		userL.add(new User(3,"Willy"));
	}
	
	void Create(User user)
	{
		userL.add(user);
	}
	
	//update
	void Update(User user, int id)
	{
		Optional<User> foundUser = FindById(id);
			
		if (foundUser.isPresent())
		{
			userL.set(userL.indexOf(foundUser.get()), user);
		}
	}
	
	//delete
	void Delete(int id)
	{
		userL.removeIf(run -> run.id() == id);
	}
	
	public String toString()
	{
		return userL.toString();
	}



	Optional<User> FindById(int id) 
	{
		return userL.stream().filter(run -> run.id() == id).findFirst();
	}
	
}
