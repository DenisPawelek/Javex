package pl.javex.User;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import pl.javex.Adress.AddressM;
import pl.javex.Date.DateM;
import pl.javex.Email.EmailM;



@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class UserM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(31)", nullable=false)
	protected String name;
	@Column(name = "surr", columnDefinition = "varchar(63)", nullable=false)
	protected String surrname;
	
	@Column(name = "passHash", columnDefinition = "varchar(255)", nullable=false)
	protected String password;
	@Column(name = "passHash", columnDefinition = "varchar(255)", nullable=false)
	protected String userName;
	
	@Column(name = "phone_number", nullable=false)
	protected int phone;
	@JoinColumn(name = "address_id", nullable=false)
	protected AddressM address;
	@OneToOne
	@JoinColumn(name = "email_id", nullable=false)
	protected EmailM email;
	
	@Column(name = "role", columnDefinition = "default 0", nullable=false)
	protected int role;
	
	@JoinColumn(name = "bd_id", nullable=false)
	protected DateM bd;
	
	@JoinColumn(name = "jd_id", nullable=false)
	protected DateM jd;
	
	

	

		

	
}
