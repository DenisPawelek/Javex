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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postal_codes")
@Getter
@Setter
public class PostalCodeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "postal_code", columnDefinition = "varchar(7)", nullable = false)
	protected String value;

	@ManyToOne
	@JoinColumn(name = "city_id")
	@JsonIgnoreProperties(value={
			"postalCodes"
	})
	protected CityM city;

	@OneToMany(mappedBy = "postalCode")
	@JsonIgnoreProperties(value={
			"users",
			"transactions",
			"postalCode"
	})
	protected List<AddressM> addresses;

}
