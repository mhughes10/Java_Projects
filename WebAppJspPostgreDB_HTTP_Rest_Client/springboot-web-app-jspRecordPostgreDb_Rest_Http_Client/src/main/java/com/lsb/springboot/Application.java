package com.lsb.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.lsb.springboot.userv2.restclient.httpclient.UserHTTPClient;
import com.lsb.springboot.userv2.restclient.httpclient.UserRecordV2;

@SpringBootApplication
public class Application 
{
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
		 log.info("Application has started successfully!");
	}
	
	@Bean
	UserHTTPClient userHTTPClient()
	{
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHTTPClient.class);
	}
	
	@Bean
	CommandLineRunner runner(UserHTTPClient client)
	{
		return args -> 
		{
			List<UserRecordV2> userRV2L = client.findAll();
			System.out.println(userRV2L);
			
			UserRecordV2 userRV2 = client.findById(1);
			System.out.println(userRV2);
		};
	}

}
