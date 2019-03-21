package pl.javastart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.javastart.model.Person;
import pl.javastart.repositotory.PersonRepository;

@Controller
public class PersonController {
	
	PersonRepository personRepo;
	
	@Autowired
	PersonController(PersonRepository personRepo){
		this.personRepo = personRepo;
	}
	
	@RequestMapping("/people/id/{id}")
	public String showPersonById(@PathVariable("id") Long id, Model model) {
		List<Person> list = new ArrayList<Person>();
		list.add(personRepo.findById(id).get());
		model.addAttribute("list",list);
		return "showall";
	}
	
	@RequestMapping("/people/names/{name}")
	public String showPersonByName(@PathVariable("name") String name, Model model) {
		List<Person> list = new ArrayList<Person>();
		list = personRepo.findAllByName(name);
		model.addAttribute("list",list);
		return "showall";
	}
	
	@RequestMapping("/people/surnames/{surname}")
	public String showPersonBySurname(@PathVariable("surname") String surname, Model model) {
		List<Person> list = new ArrayList<Person>();
		list = personRepo.findAllBySurname(surname);
		model.addAttribute("list",list);
		return "showall";
	}

}
