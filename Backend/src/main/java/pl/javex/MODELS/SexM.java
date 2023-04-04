package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "sex")
public class SexM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@Column(name = "sex_name", columnDefinition = "varchar(15)", nullable=false)
	protected String name; 
	
	@OneToMany(mappedBy="sex")
	protected List<ProductM> products;
}
