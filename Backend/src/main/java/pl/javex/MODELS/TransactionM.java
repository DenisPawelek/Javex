package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class TransactionM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnoreProperties(value={
			"transactions"
	})
	protected UserM user;

	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	@JsonIgnoreProperties(value={
			"users",
			"transactions"
	})
	protected AddressM address;

	@ManyToOne
	@JoinColumn(name = "date_id", nullable = false)
	@JsonIgnoreProperties(value={
			"usersbd",
			"usersjd",
			"transactions"
	})
	protected DateM date;

//	@OneToOne
//	@JoinColumn(name = "desc_id", nullable = false)
//	protected DescriptionM description;

	@OneToOne
	@JoinColumn(name = "invoice_id", nullable = true)
	protected InvoiceM invoice;

	@OneToMany(mappedBy = "transaction")
	@JsonIgnoreProperties(value={
			"transaction"
	})
	protected List<OrderM> orders;
}
