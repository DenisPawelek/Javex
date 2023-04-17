package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cities")
@Getter @Setter public class CityM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "city_name", columnDefinition = "varchar(31)", nullable=false)
	protected String name;
	
	@OneToMany(mappedBy="city")
	protected List<PostalCodeM> postalCodes;
	
	
}