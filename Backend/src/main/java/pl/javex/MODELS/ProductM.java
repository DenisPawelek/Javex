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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class ProductM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "amount", nullable = false)
	protected Long amount;

	@Column(name = "price", nullable = false)
	protected Long price;

	@OneToOne
	@JoinColumn(name = "desc_id", nullable = false)
	protected DescriptionM description;

	@ManyToOne
	@JoinColumn(name = "material_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products"
	})
	protected MaterialM material;

	@ManyToMany
	@JoinTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
	@JsonIgnoreProperties(value={
			"products"
	})
	protected List<ColorM> colors;

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

	@ManyToMany
	@JoinTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
	@JsonIgnoreProperties(value={
			"products"
	})
	protected List<SizeM> sizes;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products"
	})
	protected BrandM brand;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products",
			"productType"
	})
	protected TypeM type;

	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties(value={
			"product"
	})
	protected List<OrderM> orders;

}
