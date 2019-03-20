package pl.javastart.repositotory; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}
