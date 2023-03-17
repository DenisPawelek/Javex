package pl.opole.uni.springWebApp.models;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long Id;
	
	protected char symbol;
	@Column(nullable=false)
	protected String name;
	
	@OneToMany(mappedBy = "brand")
	protected List<Model> models;
	
	
	public Brand(long id, char symbol, String name) {
		super();
		Id = id;
		this.symbol = symbol;
		this.name = name;
	}
	public Brand(char symbol, String name) {
		super();
		this.symbol = symbol;
		this.name = name;
	}
	public Brand() {}
	
	
	
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
	
	
	
}
