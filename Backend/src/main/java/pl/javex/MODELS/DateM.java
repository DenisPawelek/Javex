package pl.javex.MODELS;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dates")
@Getter
@Setter
public class DateM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "date", nullable = false)
	protected Date date;

	@OneToMany(mappedBy = "userBd")
	protected List<UserM> usersbd;

	@OneToMany(mappedBy = "userJd")
	protected List<UserM> usersjd;

	@OneToMany(mappedBy = "date")
	protected List<TransactionM> transactions;
}
