package pl.javex.User.Admin;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.Address.AddressM;
import pl.javex.LOG.AdminLogM;
import pl.javex.User.UserM;

@Entity
@Table(name = "admins")
abstract public class AdminM  extends UserM{

	@OneToOne(mappedBy ="admin")
	private AdminLogM login;
	@Column(name = "domainemail")
	private String damain_email;
	private int phone;
	private Date exp_date;
	
	@ManyToOne
	@JoinColumn(name = "correspondenceadress")
	private AddressM corr_address;

	protected AdminLogM getLogin() {
		return login;
	}

	protected void setLogin(AdminLogM login) {
		this.login = login;
	}

	protected String getDamain_email() {
		return damain_email;
	}

	protected void setDamain_email(String damain_email) {
		this.damain_email = damain_email;
	}

	protected int getPhone() {
		return phone;
	}

	protected void setPhone(int phone) {
		this.phone = phone;
	}

	protected Date getExp_date() {
		return exp_date;
	}

	protected void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	protected AddressM getCorr_address() {
		return corr_address;
	}

	protected void setCorr_address(AddressM corr_address) {
		this.corr_address = corr_address;
	}
	
	
	
	
}
