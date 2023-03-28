package pl.javex.Description;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "descriptions")
public class DescriptionM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected String value;
}
