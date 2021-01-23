package com.dempapp.pack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dempapp.pack.entities.Person;
import com.dempapp.pack.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}
	
	public void save(Person person) {
		this.personRepository.save(person);
	}
	
	
	
}










