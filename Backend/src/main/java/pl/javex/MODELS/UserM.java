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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "users")
@Getter @Setter public class UserM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(31)", nullable=false)
	protected String name;
	@Column(name = "surr", columnDefinition = "varchar(63)", nullable=false)
	protected String surrname;
	
	@Column(name = "pass_hash", columnDefinition = "varchar(255)", nullable=false)
	protected String password;
	@Column(name = "user_name", columnDefinition = "varchar(255)", nullable=false)
	protected String userName;
	
	@Column(name = "phone_number", nullable=false)
	protected int phone;
	

	@ManyToOne
	@JoinColumn(name = "address_id", nullable=false)
	protected AddressM userAddress;
	
	@OneToOne
	@JoinColumn(name = "email_id", nullable=false)
	protected EmailM email;
	
	@Column(name = "role", nullable=false)
	protected int role;
	

	@ManyToOne
	@JoinColumn(name = "bd_id", nullable=false)
	protected DateM userBd;

	@ManyToOne
	@JoinColumn(name = "jd_id", nullable=false)
	protected DateM userJd;
	
	@OneToMany(mappedBy = "user")
	protected List<TransactionM> transactions;

	

		

	
}
