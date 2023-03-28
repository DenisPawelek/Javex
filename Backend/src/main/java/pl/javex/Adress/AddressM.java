package pl.javex.Adress;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.User.UserM;

@Entity
@Table(name="addresses")
public class AddressM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	protected String flat;
	protected String house;
	protected String street;
	
	@JoinColumn(name = "postal_id")
	protected PostalCodeM postalCode;
	
	@OneToMany(mappedBy="address")
	protected List<UserM> users;
	
}
