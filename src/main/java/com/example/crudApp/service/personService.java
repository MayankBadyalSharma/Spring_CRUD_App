package com.example.crudApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudApp.entity.person;
import com.example.crudApp.repo.personRepository;

@Service
public class personService {

	@Autowired
    private personRepository personRepo;
	
	 // Create a new person
    public person createPerson(person person) {
        return personRepo.save(person);
    }

    // Get all persons
    public List<person> getAllPersons() {
        return personRepo.findAll();
    }

    // Get a person by ID
    public Optional<person> getPersonById(Long id) {
        return personRepo.findById(id);
    }

    // Update an existing person
    public person updatePerson(Long id, person personDetails) {
        if (personRepo.existsById(id)) {
            personDetails.setId(id);
            return personRepo.save(personDetails);
        }
        return null;
    }

    // Delete a person
    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}

