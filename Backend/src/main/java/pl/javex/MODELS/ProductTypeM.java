package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_types")
@Getter
@Setter
public class ProductTypeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "prodtype_name", columnDefinition = "varchar(15)", nullable = false)
	protected String name;

	@OneToMany(mappedBy = "productType")
	@JsonIgnoreProperties(value={
			"productType"
	})
	protected List<TypeM> productTypes;
}
