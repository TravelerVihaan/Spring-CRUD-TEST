package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.javastart.repositotory.PersonRepository;

@Controller
public class DeleteController {
	
	private PersonRepository personRepo;
	
	@Autowired
	public DeleteController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	@GetMapping("/deleteperson")
	public String deletePersonPage() {
		return "deleteperson";
	}

	@PostMapping("/delete")
	public String deletePerson(Model model, @RequestParam long id) {
		if(checkNotEmpty(id)) {
			if(!personRepo.findById(id).isEmpty()) {
				personRepo.deleteById(id);
				return "success";
			}else {
				return "error";
			}
		}
		return "error";
			
	}
	
	@GetMapping("/error")
	public String error() {
		return "Error";
	}
	
	private boolean checkNotEmpty(Long id) {
        return (id!=null && id > 0);
 }
	
}
