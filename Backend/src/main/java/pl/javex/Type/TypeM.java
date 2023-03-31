package pl.javex.Type;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.Product.ProductM;
import pl.javex.ProductType.ProductTypeM;

@Entity
@Table( name = "types" )
public class TypeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@Column(name = "type_name", columnDefinition = "varchar(31)", nullable=false)
	protected String name;
	
	@ManyToOne
	@JoinColumn(name="id_product_type")
	protected ProductTypeM productType;
	
	@OneToMany(mappedBy="type")
	protected List<ProductM> products;
}
