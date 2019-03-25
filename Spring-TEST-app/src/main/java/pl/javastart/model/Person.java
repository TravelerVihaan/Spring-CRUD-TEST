package pl.javastart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	@NotNull
	private String surname;
	// TODO przetestowac cascadetype remove i merge
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "id_details")
	private PersonDetails personDetails;
	
	Person(){}
	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.personDetails = new PersonDetails("","");
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public PersonDetails getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}
