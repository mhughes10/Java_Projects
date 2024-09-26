package com.lsb.springboot.userv2.restclient.httpclient;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface UserHTTPClient 
{
	@GetExchange("/users")
	List<UserRecordV2> findAll();
	
	@GetExchange("/users/{id}")
	UserRecordV2 findById(@PathVariable Integer id);
}
