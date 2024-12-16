package com.example.crudApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudApp.entity.person;

public interface personRepository extends JpaRepository<person, Long>{

}
