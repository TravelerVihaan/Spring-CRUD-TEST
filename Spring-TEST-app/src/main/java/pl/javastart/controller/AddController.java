package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.javastart.model.Person;
import pl.javastart.repositotory.PersonRepository;

@Controller
public class AddController {
	
	private PersonRepository personRepo;
	
	@Autowired
	public AddController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	@GetMapping("/addperson")
	public String addPersonPage() {
		return "addperson";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam String name, @RequestParam String surname, Model model) {
		if(checkNotEmpty(name, surname)) {
			Person person = new Person(name,surname);
			personRepo.save(person);
			return "success";
		}else {
			return "error";
		}
	}
	
	 private boolean checkNotEmpty(String title, String content) {
	        return (title!=null && title.length()>0)
	                && (content!=null && content.length()>0);
	 }
	
}
