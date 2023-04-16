package pl.javex.MODELS;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brands")
@Getter @Setter public class BrandM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@OneToMany(mappedBy = "brand")
	protected List<ProductM> products;

	@OneToOne
	@JoinColumn(name = "desc_id")
	protected DescriptionM description;
	
	@Column(name = "logo_url", columnDefinition = "varchar(255)", nullable=false)
	protected String logoUrl;
}
