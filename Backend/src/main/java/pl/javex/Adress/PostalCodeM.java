package pl.javex.Adress;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="postal_codes")
public class PostalCodeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	protected String value;
	
	@JoinColumn(name = "city_id")
	protected CityM city;
	
	@OneToMany(mappedBy="postalCode")
	protected List<AddressM> addresses;
}
