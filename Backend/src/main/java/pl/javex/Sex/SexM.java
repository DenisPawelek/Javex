package pl.javex.Sex;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.Product.ProductM;

@Entity
@Table( name = "sex")
public class SexM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected String name; 
	
	@OneToMany(mappedBy="sex")
	protected List<ProductM> products;
}