package pl.javex.Material;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.Description.DescriptionM;
import pl.javex.Product.ProductM;

@Entity
@Table(name = "materials")
public class MaterialM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column(name = "material_name", columnDefinition = "varchar(31)", nullable=false)
	protected String name;
	
	@OneToOne
	@JoinColumn(name = "description_id", nullable=false)
	protected DescriptionM description;
	
	@OneToMany(mappedBy = "material")
	protected List<ProductM> products;

	
	
}
