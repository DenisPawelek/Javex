package pl.javex.Address;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Adress")
public class AddressM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;	//rozbijanie pod kątem kluczy wyszukiwania
	protected String country;
	protected String city;
	@Column(name = "postalcode")
	protected String postal_code;
	protected String street;
	protected String house;

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected String getCountry() {
		return country;
	}

	protected void setCountry(String country) {
		this.country = country;
	}

	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected String getPostal_code() {
		return postal_code;
	}

	protected void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	protected String getStreet() {
		return street;
	}

	protected void setStreet(String street) {
		this.street = street;
	}

	protected String getHouse() {
		return house;
	}

	protected void setHouse(String house) {
		this.house = house;
	}	
}
