package com.example.demoPerson.animal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Animal")
@Entity
public class Animal {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	Long id;
	private String type;
	private String name;
	
	public Animal() {}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	

}
