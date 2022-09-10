package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MovieDAO {
	@Autowired
	MovieRepo repo;
	//insert a single object
	public Movie insert(Movie s) {
		return repo.save(s);
	}
	public Movie findbyid(Integer id) {
		Movie rs = repo.findById(id).orElse(null);
		return rs;
	}
	
	
	//retrieve all the objects
	public List<Movie> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int gid) {
		repo.deleteById(gid);
		return "deleted the id value:"+gid; 
	}
	
	
	//update
	public Movie update(Movie s) {
		Movie ss=repo.findById(s.getId()).orElse(null);
		ss.setName(s.getName());
		ss.setDate(s.getDate());
		ss.setPrice(s.getPrice());
		
		return repo.save(ss);
	}
	
}
