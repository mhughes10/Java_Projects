package com.lsb.springboot;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class MVC 
{	
	/*
	 * @GetMapping("/Available") String Home() { return "Available Users"; }
	 */
	
	private final UserList userL;
	
	public MVC(UserList userL)
	{
		this.userL = userL;
	}
	
	//put
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	void Update(@Valid @RequestBody User user, @PathVariable int id)
	{
		userL.Update(user, id);
	}
	
	//post
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	void Create(@Valid @RequestBody User user)
	{
		userL.Create(user);
	}
	
	//delete
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable int id)
	{
		userL.Delete(id);
	}
	
	@GetMapping("")
	String FindAll()
	{
		return userL.toString();
	}
	
	@GetMapping("/{id}")
	String FindById(@PathVariable int id)
	{
		Optional<User> user = userL.FindById(id);
		
		if (user.isEmpty())
		{
			throw new UserNotFoundException();
		}
		
		return user.get().toString();
	}
}
