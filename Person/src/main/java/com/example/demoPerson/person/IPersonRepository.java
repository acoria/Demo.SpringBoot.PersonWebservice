package com.example.demoPerson.person;

import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long>{ }
