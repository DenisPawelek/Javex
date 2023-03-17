package pl.javex.LOG;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.User.Admin.AdminM;

@Entity
@Table(name = "adml")
public class AdminLogM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "admin_id")
	private AdminM admin;
	
	private String hash;
	private String name;
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected AdminM getAdmin() {
		return admin;
	}
	protected void setAdmin(AdminM admin) {
		this.admin = admin;
	}
	protected String getHash() {
		return hash;
	}
	protected void setHash(String hash) {
		this.hash = hash;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	
	
}
