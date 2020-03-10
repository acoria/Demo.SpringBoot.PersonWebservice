package com.example.demoPerson.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class AnimalController {
	
	@Autowired
	IAnimalRepository animalRepo;
	
	@GetMapping("/animals")
	public Iterable<Animal> getAllAnimals(){
		return animalRepo.findAll();
	}
	
	@GetMapping("/animals/{id}")
	public Animal findAnimalById(@PathVariable(name = "id") Long id) {
		return animalRepo.findById(id).get();
	}
	
	@PostMapping("/animals")
	public Iterable<Animal> addAnimal(@RequestBody Iterable<Animal> animals) {
		return animalRepo.saveAll(animals);
	}
}
