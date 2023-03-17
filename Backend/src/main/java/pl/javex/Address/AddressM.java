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

import pl.javex.LOG.AdminLogM;
import pl.javex.User.Admin.AdminM;
import pl.javex.User.Admin.Reprezentative.ReprezentativeM;
import pl.javex.User.Client.ClientM;
import pl.opole.uni.springWebApp.models.Model;

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
	
	@OneToMany(mappedBy = "delivery_adress")
	protected List<ClientM> clients;
	
	@OneToMany(mappedBy = "corr_address")
	protected List<AdminM> admins;
	
	@OneToMany(mappedBy = "pickup_address")
	protected List<ReprezentativeM> reprezentatives;

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

	protected List<ClientM> getClients() {
		return clients;
	}

	protected void setClients(List<ClientM> clients) {
		this.clients = clients;
	}

	protected List<AdminM> getAdmins() {
		return admins;
	}

	protected void setAdmins(List<AdminM> admins) {
		this.admins = admins;
	}

	protected List<ReprezentativeM> getReprezentatives() {
		return reprezentatives;
	}

	protected void setReprezentatives(List<ReprezentativeM> reprezentatives) {
		this.reprezentatives = reprezentatives;
	}
	
	
	
	
}
