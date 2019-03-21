package pl.javastart.repositotory;

import org.springframework.data.repository.CrudRepository;

import pl.javastart.model.PersonDetails;

public interface PersonDetailsRepository extends CrudRepository<PersonDetails,Long>{

}
