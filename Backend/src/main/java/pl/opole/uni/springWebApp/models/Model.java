package pl.opole.uni.springWebApp.models;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected char symbol;
	protected String name;
	
	@ManyToOne
	@JoinColumn(name="id_brand")
	protected Brand brand;
	
	@OneToMany(mappedBy="model")
	protected List<Car> cars;
	
	
	

	public Model() {};


	
	protected long getId() {
		return Id;
	}
	protected void setId(long id) {
		Id = id;
	}

	
	protected char getSymbol() {
		return symbol;
	}
	protected void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}


	protected Brand getBrand() {
		return brand;
	}
	protected void setBrand(Brand brand) {
		this.brand = brand;
	}

}
