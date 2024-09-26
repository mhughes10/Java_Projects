package com.lsb.springboot.userv2.restclient.httpclient;

public record Address
(
		String street,
		String suite,
		String city,
		String zipcode,
		Geo geo
) 
{

}
