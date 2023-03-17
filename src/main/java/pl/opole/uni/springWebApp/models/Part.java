package pl.opole.uni.springWebApp.models;



import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected char symbol;
	protected String name;
	
	protected int status;

	@ManyToMany(mappedBy="parts")
	protected List<Car> cars;
	
	
	
	public Part(long id, char symbol, String name, int status) {
		super();
		Id = id;
		this.symbol = symbol;
		this.name = name;
		this.status = status;
	}
	public Part(char symbol, String name, int status) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.status = status;
	}
	public Part() {}
	
	
	
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

	
	protected int getStatus() {
		return status;
	}
	protected void setStatus(int status) {
		this.status = status;
	}
	
}

