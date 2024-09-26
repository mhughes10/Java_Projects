package com.lsb.springboot.userv1.postgredb.docker;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserList extends ListCrudRepository<UserRecordV1, Integer>
{
	List<UserRecordV1> findAllByName(String name);
}
