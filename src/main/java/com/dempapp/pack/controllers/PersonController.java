package com.dempapp.pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dempapp.pack.entities.Person;
import com.dempapp.pack.services.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/")
	public String displayHome(Model model) {
		model.addAttribute("persons", this.personService.findAll());
		return "home";
	}
	
	@GetMapping("/add")
	public String displayAdd(Model model) {
		model.addAttribute("person", new Person());
		return "add";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute("person") Person person, BindingResult error, Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("msg", "binding errors!!!!!");
			model.addAttribute("msgColour", "danger");
			return "add";
		}
		
		this.personService.save(person);
		
		model.addAttribute("msg", "person has been saved successfully");
		model.addAttribute("msgColour", "success");
		
		return "add";
	}
	
	
	
}







