package com.notthebest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notthebest.demo.model.Person;
// Declare repository based on the person entity interface
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
