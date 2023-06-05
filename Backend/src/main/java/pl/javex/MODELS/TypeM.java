package pl.javex.MODELS;

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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "types")
@Getter
@Setter
public class TypeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "type_name", columnDefinition = "varchar(31)", nullable = false)
	protected String name;

	@Getter(AccessLevel.PRIVATE)
	@ManyToOne
	@JoinColumn(name = "id_product_type")
	protected ProductTypeM productType;

	@Getter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy = "type")
	protected List<ProductM> products;
}
