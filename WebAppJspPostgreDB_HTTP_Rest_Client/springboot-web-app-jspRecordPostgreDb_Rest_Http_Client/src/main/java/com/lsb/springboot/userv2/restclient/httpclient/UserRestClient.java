package com.lsb.springboot.userv2.restclient.httpclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserRestClient 
{
	private final RestClient restClient;
	
	public UserRestClient(RestClient.Builder builder)
	{
		this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
	}
	
	public List<UserRecordV2> findAll()
	{
		return restClient.get().uri("/users").retrieve().body(new ParameterizedTypeReference<>() {});
	}
	
	public UserRecordV2 findById(Integer id)
	{
		return restClient.get().uri("/users/{id}", id).retrieve().body(UserRecordV2.class);
	}
}
