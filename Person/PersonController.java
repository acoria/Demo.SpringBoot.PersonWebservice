package com.example.demoPerson.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PersonController {
	
	PersonDAO dao = new PersonDAO();
		
	@GetMapping("/persons")
	public List<Person> getPersons(){
		return dao.getAll();
	}
	
	@GetMapping("/persons/{id}")
	public String getSinglePropertyOfPerson(@PathVariable(name = "id") int personId, @RequestParam(name = "prop") String prop) {
		Person person = dao.findPersonById(personId);
		switch (prop) {
		case "firstname":
			return person.getFirstname();
		case "lastname":
			return person.getLastname();
		default:
			break;
		}
		return null;
	}
	
	@PutMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		dao.addPerson(person);
		return person;
	}
	
	@DeleteMapping("/persons/{id}")
	public boolean deletePersonById(@PathVariable(name = "id") int id) {
		return dao.deleteById(id);
	}
	
}
