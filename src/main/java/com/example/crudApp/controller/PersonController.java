package com.example.crudApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudApp.entity.person;
import com.example.crudApp.service.personService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private personService personServ;

    // Create a new person
    @PostMapping
    public person createPerson(@RequestBody person persons) {
        return personServ.createPerson(persons);
    }

    // Get all persons
    @GetMapping
    public List<person> getAllPersons() {
        return personServ.getAllPersons();
    }

    // Get a person by ID
    @GetMapping("/{id}")
    public ResponseEntity<person> getPersonById(@PathVariable Long id) {
        Optional<person> person = personServ.getPersonById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing person
    @PutMapping("/{id}")
    public ResponseEntity<person> updatePerson(@PathVariable Long id, @RequestBody person personDetails) {
        person updatedPerson = personServ.updatePerson(id, personDetails);
        return updatedPerson != null ? ResponseEntity.ok(updatedPerson) : ResponseEntity.notFound().build();
    }

    // Delete a person
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personServ.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}

