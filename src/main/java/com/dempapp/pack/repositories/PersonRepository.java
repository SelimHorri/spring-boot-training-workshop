package com.dempapp.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dempapp.pack.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	
	
}








