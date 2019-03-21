package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.javastart.model.Person;
import pl.javastart.model.PersonDetails;
import pl.javastart.repositotory.PersonDetailsRepository;
import pl.javastart.repositotory.PersonRepository;

@Controller
public class DetailsController {
	
	private PersonRepository personRepo;
	private PersonDetailsRepository detailsRepo;
	
	@Autowired
	public DetailsController(PersonRepository personRepo) {
		this.personRepo = personRepo;
		//this.detailsRepo = detailsRepo;
	}

	@GetMapping("/adddetails")
	public String addDetailsPage() {
		return "adddetails";
	}
	
	@PostMapping("/adddet")
	public String add(@RequestParam Long id, @RequestParam String city, @RequestParam String country, Model model) {
		if(checkNotEmpty(id)) {
			if(!personRepo.findById(id).isEmpty()) {
				Person person = personRepo.findById(id).get();
				PersonDetails personDet = new PersonDetails(city,country);
				person.setPersonDetails(personDet);
				//detailsRepo.save(personDet);
				personRepo.save(person);
				return "success";
			}else {
				return "error";
			}
		}
		return "error";
	}
		
	private boolean checkNotEmpty(Long id) {
		return (id!=null && id > 0);
	}
}
