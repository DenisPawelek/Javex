package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="postal_codes")
@Getter @Setter public class PostalCodeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "postal_code", columnDefinition = "varchar(7)", nullable=false)
	protected String value;
	

	@ManyToOne
	@JoinColumn(name = "city_id")
	protected CityM city;
	
	@OneToMany(mappedBy="postalCode")
	protected List<AddressM> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CityM getCity() {
		return city;
	}

	public void setCity(CityM city) {
		this.city = city;
	}
	
	
}
