package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter @Setter public class CategoryM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column(name = "category_name", columnDefinition = "varchar(15)", nullable=false)
	protected String name;
	
	@OneToMany(mappedBy="category")
	protected List<ProductM> products;
}
