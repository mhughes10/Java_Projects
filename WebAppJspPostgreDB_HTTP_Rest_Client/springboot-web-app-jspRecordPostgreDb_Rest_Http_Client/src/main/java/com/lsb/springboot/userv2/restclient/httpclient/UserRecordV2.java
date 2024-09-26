package com.lsb.springboot.userv2.restclient.httpclient;

public record UserRecordV2
(
		Integer id,
		String name,
		String Username,
		String email,
		Address address,
		String phone,
		String website,
		Company company
)
{

}
