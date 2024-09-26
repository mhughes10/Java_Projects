package com.lsb.springboot.userv1.postgredb.docker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import(JdbcClientUserList.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JdbcClientUserListTest 
{
	
	@Autowired
	JdbcClientUserList userList;
	
	@BeforeEach
	void setUp()
	{
		userList.createM(new UserRecordV1(1,"marshall",null));
		userList.createM(new UserRecordV1(2,"Hughes",null));
		userList.createM(new UserRecordV1(3,"Kimmie",null));
	}
	
	@Test
	void shouldFindAllUsers()
	{
		List<UserRecordV1> userRV1L = userList.findAllM();
		assertEquals(3, userRV1L.size(), "Should have returned 3 users");
	}

}
