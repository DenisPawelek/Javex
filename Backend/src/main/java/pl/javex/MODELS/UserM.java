package pl.javex.MODELS;

import java.util.Collection;
import java.util.Collections;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserM implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", columnDefinition = "varchar(31)", nullable = false)
	protected String name;
	@Column(name = "surr", columnDefinition = "varchar(63)", nullable = false)
	protected String surrname;
	@Column(name = "pass_hash", columnDefinition = "varchar(255)", nullable = false)
	protected String password;
	@Column(name = "user_name", columnDefinition = "varchar(255)", nullable = false)
	protected String username;
	@Column(name = "role", nullable = false)
	protected String role;
	@Column(name = "phone_number", nullable = false)
	protected Integer phone;
	
	@Column(nullable = false) protected Short s_credentialsNonExpired;
	@Column(nullable = false) protected Short s_accountNonExpired;
	@Column(nullable = false) protected Short s_accountNonLocked;
	@Column(nullable = false) protected Short s_enabled;
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
//		return !accountNonExpired.equals(-1);
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
//		return !accountNonLocked.equals(-1);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
//		return !credentialsNonExpired.equals(-1);
	}

	@Override
	public boolean isEnabled() {
		return true;
//		return !enabled.equals(-1);
	}


	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(role));
	}
	
	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	@JsonIgnoreProperties(value={
			"users",
			"transactions"
	})
	protected AddressM userAddress;
	@OneToOne
	@JoinColumn(name = "email_id", nullable = false)
	protected EmailM email;
	@ManyToOne
	@JoinColumn(name = "bd_id", nullable = false)
	@JsonIgnoreProperties(value={
			"usersbd",
			"usersjd",
			"transactions"
	})
	protected DateM userBd;
	@ManyToOne
	@JoinColumn(name = "jd_id", nullable = false)
	@JsonIgnoreProperties(value={
			"usersbd",
			"usersjd",
			"transactions"
	})
	protected DateM userJd;

	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties(value={
			"user"
	})
	private List<TransactionM> transactions;

}
