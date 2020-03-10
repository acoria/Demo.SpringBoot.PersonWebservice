package com.example.demoPerson.person;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PersonController {
	
	@Autowired
	IPersonRepository personRepo;
	
	@GetMapping("/persons")
	public Iterable<Person> getPersons(Principal principal){
		return personRepo.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public String getSinglePropertyOfPerson(@PathVariable(name = "id") long personId, @RequestParam(name = "prop") String prop) {
		Optional<Person> person = personRepo.findById(personId);
		switch (prop) {
		case "firstname":
			return person.get().getFirstname();
		case "lastname":
			return person.get().getLastname();
		default:
			break;
		}
		return null;
	}
	
	@PostMapping("/persons")
	public Iterable<Person> addPerson(@RequestBody Iterable<Person> persons) {
		return personRepo.saveAll(persons);
	}
	
	
	@DeleteMapping("/persons/{id}")
	public Person deletePersonById(@PathVariable(name = "id") long id) {
		Person person = personRepo.findById(id).orElseThrow(()-> new RuntimeException());
		personRepo.delete(person);
		return person;
	}
}
