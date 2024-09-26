package com.lsb.springboot;

import java.util.List;
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
	 @PutMapping("/update/name") void updateM(@Valid @RequestBody UserRecord user)
	 { 
		 userL.save(user);
	 }
	 
	//post
	 @ResponseStatus(HttpStatus.CREATED)
	 @PostMapping("") void Create(@Valid @RequestBody UserRecord user) 
	 {
		 userL.save(user);
	 }
	 
	 //delete
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 @DeleteMapping("/{id}") void deleteM(@PathVariable int id) 
	 { 
		 userL.delete(userL.findById(id).get());
	 }
	 
	 @GetMapping("/name/{name}")
	 List<UserRecord> findBylocation(@PathVariable String name)
	 {
		 return userL.findAllByName(name);
	 }
	 
	 @GetMapping("")
	 List<UserRecord> findAllM() 
	 { 
		 return userL.findAll(); 
	 }
	 
	 @GetMapping("/{id}") UserRecord findByIdM(@PathVariable int id) { Optional<UserRecord>
	 user = userL.findById(id);
	 
	 if (user.isEmpty()) { throw new UserNotFoundException(); }
	 
	 return user.get(); }
	 
}
