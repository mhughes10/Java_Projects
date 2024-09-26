package com.lsb.springboot;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class User 
{
	@PositiveOrZero
	private int id;
	
	@NotNull
	private String name;
	
	public User(int id, String name)
	{
		this.id = id;
		this.name = name;
		
	}
	
	public String toString()
	{
		return "\n	{"+"\n		ID: " + id + ",\n" + "		Name: " + name + "\n	"+"\n	}" + "\n";
	}

	public int id() 
	{
		
		return id;
	}
}
