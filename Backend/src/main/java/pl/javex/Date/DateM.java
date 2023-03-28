package pl.javex.Date;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.User.UserM;

@Entity
@Table(name="dates")
public class DateM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	protected Date date;
	
	@OneToMany(mappedBy="bd")
	protected List<UserM> usersbd;
	
	@OneToMany(mappedBy="jd")
	protected List<UserM> usersjd;
}
