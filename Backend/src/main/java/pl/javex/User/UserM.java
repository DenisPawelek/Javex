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
	
	
	protected String name;
	protected String surrname;
	
	protected String password;
	protected String userName;
	
	@JoinColumn(name = "bd_id")
	protected DateM bd;
	
	@JoinColumn(name = "jd_id")
	protected DateM jd;
	
	protected int role;
	
	@JoinColumn(name = "address_id")
	protected AddressM address;
	
	@OneToOne
	protected EmailM email;
	
	protected int phone;
		

	
}
