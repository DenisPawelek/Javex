package pl.javex.User;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;



@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class UserM {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	protected String name;
	protected String surrname;
	protected String email;
	protected Date bd;
	
	protected Date join_date;

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getSurrname() {
		return surrname;
	}

	protected void setSurrname(String surrname) {
		this.surrname = surrname;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected Date getBd() {
		return bd;
	}

	protected void setBd(Date bd) {
		this.bd = bd;
	}

	protected Date getJoin_date() {
		return join_date;
	}

	protected void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	
	
	
	
	
}
