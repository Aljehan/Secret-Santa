package com.notthebest.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notthebest.demo.model.Person;
import com.notthebest.demo.repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo repo;
	// function to delete person from repository
	public void deletePerson(int id) {
		Person person = repo.findById(id).get();
		repo.delete(person);
	}
	// add person to repository 
	public void addPerson(Person person) {
		repo.save(person);
	}

	// get a list of all people saved in the repo
	public List<Person> getPeople() {
		return repo.findAll();
	}
	// generate matches using a hash table. associate every person to one random person who hasnt recieved a gift yet
	public Map<String, String> generateMatches() {
		List<Person> list = getPeople();
		int N = list.size();
		boolean[] used =  new boolean[N];
		int oddOneOut = -1;
		Map<String, String> matches = new HashMap<>();
		
		if(N % 2 == 1) {
			oddOneOut = randomMatch(N);
			matches.put(list.get(oddOneOut).getName(), "Nobody");
		}
		
		for(int i = 0; i<N; i++) {
			if(i == oddOneOut) continue;
			
			int match = randomMatch(N);
			while(match == i || used[match] == true) {
				match = randomMatch(N);
			}
			used[match] = true;

			matches.put(list.get(i).getName(), list.get(match).getName());
		}
		
		return matches;
		
	}
	// helper function for generateMatches()
	private int randomMatch(int size) {
		return (int)(Math.random()*size);
	}
}
