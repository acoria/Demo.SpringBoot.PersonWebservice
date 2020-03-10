package com.example.demoPerson.person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
	
	private List<Person> persons = new ArrayList<Person>();
	
	public PersonDAO() {
		persons.add(new Person("Sheldon", "Shark"));
		persons.add(new Person("Jimmy", "Jellyfish"));
	}
	
	public Person findPersonById(int id) {
		for(Person person: persons){
			if(person.getId() == id)
				return person;
		}
		return null;
	}
	
	public List<Person> getAll(){
		return persons;
	}

	public void addPerson(Person person) {
		persons.add(person);
	}
	
	public boolean deleteById(int id) {
		for(Person person: persons) {
			if(person.getId() == id) {
				persons.remove(person);
				return true;
			}
		}
		return false;
	}

}