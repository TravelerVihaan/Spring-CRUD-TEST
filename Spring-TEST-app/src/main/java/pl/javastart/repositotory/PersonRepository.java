package pl.javastart.repositotory; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

	List<Person> findAllByName(String name);
	
	List<Person> findAllBySurname(String surname);
	
}
