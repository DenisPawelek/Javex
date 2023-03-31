package pl.javex.Color;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.javex.Product.ProductM;

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
	protected long Id;
	
	protected String name;
	
	@OneToMany(mappedBy="color")
	protected List<ProductM> products;
}
