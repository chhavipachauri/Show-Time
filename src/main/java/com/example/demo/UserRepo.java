package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {

	@Query("select user from User user where user.name=?1")
	public User findByuser(String user);
	
	@Query("select user from User user where user.password=?1")
	public User findBypassword(String password);
	
}
