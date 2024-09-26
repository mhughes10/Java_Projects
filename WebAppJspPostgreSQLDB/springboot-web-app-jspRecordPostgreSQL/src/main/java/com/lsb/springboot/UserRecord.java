package com.lsb.springboot;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserRecord
	(
		@Positive
		@Id
		Integer id,
		
		@NotNull
		String name,
		
		@Version
		Integer version
	) 
{
	
}
