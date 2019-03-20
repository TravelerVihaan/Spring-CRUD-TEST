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
public class EditController {

private PersonRepository personRepo;
	
	@Autowired
	public EditController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	@GetMapping("/editperson")
	public String editPersonPage() {
		return "editperson";
	}
	
	@PostMapping("/edit")
	public String edit(@RequestParam Long id, @RequestParam String name, @RequestParam String surname, Model model) {
		if(checkNotEmpty(id)) {
			if(!personRepo.findById(id).isEmpty()) {
				Person person = personRepo.findById(id).get();
				if(name!=null && name.length()>0)
					person.setName(name);
				if(surname!=null && surname.length()>0)
					person.setSurname(surname);
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