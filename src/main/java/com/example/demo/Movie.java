package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Movie {
@Id
	private int id;
	private String name;
	private String date;
	private String price;
}
