package pl.javex.Product;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.Brand.BrandM;
import pl.javex.Contract.ContractM;
import pl.javex.Description.DescriptionM;
import pl.javex.Material.MaterialM;
import pl.javex.Sex.SexM;
import pl.javex.Size.SizeM;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	protected long amount;
	
	protected long price;
	
	@OneToOne
	protected DescriptionM description;

	@ManyToOne
	@JoinColumn(name="id_material")
	protected MaterialM material;

//	@ManyToOne
//	@JoinColumn(name="id_color")
//	protected ColorM color;
//
//	@ManyToOne
//	@JoinColumn(name="id_category")
//	protected CategoryM category;
	
	@ManyToOne
	@JoinColumn(name="id_sex")
	protected SexM sex;
	
	@ManyToOne
	@JoinColumn(name="id_size")
	protected SizeM size;
	
	@ManyToOne
	@JoinColumn(name="id_brand")
	protected BrandM brand;
	
	@ManyToOne
	@JoinColumn(name="id_type")
	protected BrandM type;
	
	
	
	
	protected char cattegory;
	
}
