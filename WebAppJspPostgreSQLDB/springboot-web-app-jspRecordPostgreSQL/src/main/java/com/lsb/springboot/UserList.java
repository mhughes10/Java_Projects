package com.lsb.springboot;

import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface UserList extends ListCrudRepository<UserRecord, Integer>
{
	List<UserRecord> findAllByName(String name);
}
