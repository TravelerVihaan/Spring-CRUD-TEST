package pl.javastart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_details")
public class PersonDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_details")
	private Long id;
	
	@Column(nullable = true)
	private String country;
	@Column(nullable = true)
	private String city;
	
	PersonDetails(){}
	public PersonDetails(String city, String country) {
		this.city = city;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "PersonDetails [id=" + id + ", country=" + country + ", city=" + city + "]";
	}
	
	

}
