package pl.javex.Brand;

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

import pl.javex.Contract.ContractM;
import pl.javex.Description.DescriptionM;
import pl.javex.Product.ProductM;
import pl.javex.User.Admin.Reprezentative.ReprezentativeM;

@Entity
@Table(name = "brands")
public class BrandM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@OneToMany(mappedBy = "brand")
	protected List<ProductM> products;

	@OneToOne
	@Column(name = "desc_id")
	protected DescriptionM description;
	
	@Column(name = "logo")
	protected String logoUrl;
}