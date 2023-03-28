package pl.javex.Category;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.Product.ProductM;

@Entity
@Table(name = "categories")
public class CategoryM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	protected String name;
	
	@OneToMany(mappedBy="category")
	protected List<ProductM> products;
}
