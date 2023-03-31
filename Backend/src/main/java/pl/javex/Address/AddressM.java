package pl.javex.Address;

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

import pl.javex.User.UserM;

@Entity
@Table(name="addresses")
public class AddressM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name = "flat", columnDefinition = "varchar(8)", nullable=false)
	protected String flat;
	@Column(name = "house", columnDefinition = "varchar(4)", nullable=false)
	protected String house;
	@Column(name = "street", columnDefinition = "varchar(31)", nullable=false)
	protected String street;
	

	@ManyToOne
	@JoinColumn(name = "postal_id", nullable=false)
	protected PostalCodeM postalCode;
	
	@OneToMany(mappedBy="userAddress")
	protected List<UserM> users;
	
}
