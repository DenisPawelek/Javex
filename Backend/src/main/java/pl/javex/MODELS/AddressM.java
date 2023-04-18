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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class AddressM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long Id;

	@Column(name = "flat", columnDefinition = "varchar(8)", nullable = false)
	protected String flat;
	@Column(name = "house", columnDefinition = "varchar(4)", nullable = false)
	protected String house;
	@Column(name = "street", columnDefinition = "varchar(31)", nullable = false)
	protected String street;

	@ManyToOne
	@JoinColumn(name = "postal_id", nullable = false)
	protected PostalCodeM postalCode;

	@OneToMany(mappedBy = "userAddress")
	protected List<UserM> users;

	@OneToMany(mappedBy = "address")
	protected List<TransactionM> transactions;

}
