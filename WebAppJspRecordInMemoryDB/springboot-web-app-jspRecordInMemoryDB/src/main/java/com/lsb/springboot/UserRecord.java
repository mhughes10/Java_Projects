package com.lsb.springboot;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserRecord
	(
		@Positive
		int id,
		
		@NotNull
		String name
	) 
{
	
}
