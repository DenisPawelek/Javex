package pl.javex.Description;

import javax.persistence.Column;
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
	protected long id;
	
	@Column(name = "description_text", columnDefinition = "varchar(1023)", nullable=false)
	protected String value;
}
