package pl.javex.MODELS;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "date", nullable = false)
	protected Date date;

	@OneToMany(mappedBy = "userBd")
	@JsonIgnoreProperties(value={
			"userBd"
	})
	protected List<UserM> usersbd;

	@OneToMany(mappedBy = "userJd")
	@JsonIgnoreProperties(value={
			"userJd"
	})
	protected List<UserM> usersjd;

	@OneToMany(mappedBy = "date")
	@JsonIgnoreProperties(value={
			"date"
	})
	protected List<TransactionM> transactions;
}
