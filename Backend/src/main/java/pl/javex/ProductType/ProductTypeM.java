package pl.javex.ProductType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.Type.TypeM;



@Entity
@Table( name = "product_types" )
public class ProductTypeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected String name;
	
	@OneToMany(mappedBy="productType")
	protected List<TypeM> productTypes;
}
