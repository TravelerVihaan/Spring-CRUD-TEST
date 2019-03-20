package pl.javastart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.javastart.model.Person;
import pl.javastart.repositotory.PersonRepository;

@Controller
public class ListController {
	
	private PersonRepository personRepo;
	
	@Autowired
	public ListController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	@GetMapping("/show")
	public String fullList(Model model) {
			List<Person> list = new ArrayList<Person>();
			list = (List<Person>) personRepo.findAll();
			model.addAttribute("list",list);
			return "showall";
	}
}
	
