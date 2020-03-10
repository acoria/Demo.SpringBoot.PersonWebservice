package com.example.demoPerson.user;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, String>{ }
