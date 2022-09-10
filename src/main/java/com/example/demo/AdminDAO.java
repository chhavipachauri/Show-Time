package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
	@Autowired
	UserRepo repo;
	
	public User insert(User s) {
		return repo.save(s);
	}
	public List<User> getuser(){
		return repo.findAll();
	}
	public User findbyuser(String user) {
		return repo.findByuser(user);
	}
	
	
	public User findbypassword(String password) {
		return repo.findBypassword(password);
	}
	
}

