package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

<<<<<<< Updated upstream
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

=======
>>>>>>> Stashed changes
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productsuss")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class ProductM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "price", nullable = false)
	protected Long price;	
	@Column(name = "name", nullable = false)
	protected String name;	
	@OneToOne
	@JoinColumn(name = "desc_id", nullable = false)
	protected DescriptionM description;
	@ManyToOne
	@JoinColumn(name = "material_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products"
	})
	protected MaterialM material;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products"
	})
	protected CategoryM category;
	@ManyToOne
	@JoinColumn(name = "sex_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products"
	})
	protected SexM sex;
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products"
	})
	protected BrandM brand;
	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
<<<<<<< Updated upstream
	@JsonIgnoreProperties(value={
			"products",
			"productType"
	})
	protected TypeM type;
	
=======
	protected TypeM type;

	@Getter(AccessLevel.PRIVATE)
>>>>>>> Stashed changes
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties(value={
			"product"
	})
	private List<ReserveM> reserves;
//	@Getter(AccessLevel.PRIVATE)
//	@OneToMany(mappedBy = "product")
//	@JsonIgnoreProperties(value={
//			"product"
//	})
//	private List<OrderM> orders;

}
