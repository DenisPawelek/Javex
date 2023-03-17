package pl.opole.uni.springWebApp.models;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected int year;
	protected float weight;
	
	@ManyToOne
	@JoinColumn(name="id_model")
	protected Model model;

	@ManyToMany	@JoinTable(name="car_part", 
			joinColumns = {	@JoinColumn(name="id_car")	}, 
			inverseJoinColumns = {@JoinColumn(name="id_part")})
	private List<Part> parts;

	
	
	public Car() {}


	
	protected long getId() {
		return Id;
	}
	protected void setId(long id) {
		Id = id;
	}

	
	protected int getYear() {
		return year;
	}
	protected void setYear(int year) {
		this.year = year;
	}

	
	protected float getWeight() {
		return weight;
	}
	protected void setWeight(float weight) {
		this.weight = weight;
	}


	protected Model getModel() {
		return model;
	}
	protected void setModel(Model model) {
		this.model = model;
	}

	

	
}
