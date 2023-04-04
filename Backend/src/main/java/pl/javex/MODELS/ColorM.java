package pl.javex.MODELS;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "colors")
public class ColorM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@Column(name = "color_name", columnDefinition = "varchar(31)", nullable=false)
	protected String name;
	
	@OneToMany(mappedBy="color")
	protected List<ProductM> products;
}
