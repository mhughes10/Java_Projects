package com.lsb.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld 
{
	@GetMapping("/welcome")
	public String GetWelcomeMessage()
	{
		return "Hello, Your looking dandy this evening!";
	}
}
