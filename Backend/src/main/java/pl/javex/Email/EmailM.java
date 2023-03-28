package pl.javex.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emails")
public class EmailM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	protected String emailAdress;
}
