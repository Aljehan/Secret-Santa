package com.notthebest.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notthebest.demo.model.Person;
import com.notthebest.demo.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService service;
	// Index to number people based on their entry order
	@RequestMapping("index")
	public String test() {
		return "index";
	}
	// request to add a person to the list
	@GetMapping("addpeople")
	public String addPeoplePage(Model model) {
		model.addAttribute("people", service.getPeople());
		return "addpeople";
	}
	// add a person to the list
	@PostMapping("addpeople")
	public String addPeopleToRepo(Person person, Model model) {
		service.addPerson(person);
		model.addAttribute("people", service.getPeople());
		return "addpeople";
	}
	// delete a person from the list
	@PostMapping("deletepeople")
	public String deletePeopleToRepo(Integer id, Model model) {
		if(id != null)
			service.deletePerson(id);
		model.addAttribute("people", service.getPeople());
		return "addpeople";
	}
	// request to match a person to give gifts to another person
	@GetMapping("generate")
	public String generateMatches(Model model) {
		Map<String, String> matches = service.generateMatches();
		model.addAttribute("matches", matches);
		return "generate";
	}
}
