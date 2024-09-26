package com.lsb.springboot;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

//import jakarta.annotation.PostConstruct;

@Repository
public class JdbcClientUserList
{
	//private static final Logger log = LoggerFactory.getLogger(UserList.class);
	private final JdbcClient jdbcClient;
	
	public JdbcClientUserList(JdbcClient jdbcClient)
	{
		this.jdbcClient = jdbcClient;
	}
	
	public List<UserRecord> findAllM()
	{
		return jdbcClient.sql("SELECT * FROM user_record").query(UserRecord.class).list();
	}
	
	public Optional<UserRecord> findByIdM(int id)
	{
		return jdbcClient.sql("SELECT id, name FROM user_record WHERE id = :id")
				.param("id", id).query(UserRecord.class).optional();
	}
	
	public void createM(UserRecord userRecord)
	{
		var updated = jdbcClient.sql("INSERT INTO user_record (id,name) VALUES (?,?)")
				.params(List.of(userRecord.id(),userRecord.name())).update();
		
		Assert.state(updated == 1, "Failed to create User " + userRecord.name());
	}
	
	public void updateNameM(UserRecord userRecord)
	{
		var updated = jdbcClient.sql("UPDATE user_record SET name = ? WHERE id = ?")
				.params(List.of(userRecord.name(), userRecord.id())).update();
		
		Assert.state(updated == 1, "Failed to update User " + userRecord.name());
	}
	
	public void deleteM(int id)
	{
		var updated = jdbcClient.sql("DELETE FROM user_record WHERE id = :id")
				.param("id", id).update();
		
		Assert.state(updated == 1, "Failed to delete User " + id);
	}
	
	public int countM()
	{
		return jdbcClient.sql("SELECT * FROM user_record").query().listOfRows().size();
	}
	
	public List<UserRecord> findByNameM(String name)
	{
		return jdbcClient.sql("SELECT * FROM user_record WHERE name = :name")
				.param("name", name).query(UserRecord.class).list();
	}
	
	public void saveAllM(List<UserRecord> userList)
	{
		userList.stream().forEach(this::createM);
	}
}
