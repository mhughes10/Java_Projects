package com.lsb.springboot.userv1.postgredb.docker;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserRecordV1
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
