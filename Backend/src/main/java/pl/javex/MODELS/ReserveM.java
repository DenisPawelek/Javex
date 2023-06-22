package pl.javex.MODELS;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reserves")
@Getter
@Setter
public class ReserveM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
		
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@JsonIgnoreProperties(value={
			"reserves"
	})
	protected ProductM product;
	
	@Column(name = "amount", nullable = false)
	protected Long amount;
	
	@ManyToOne
	@JoinColumn(name = "color_id", nullable = false)
	@JsonIgnoreProperties(value={
			"reserves"
	})
	protected ColorM color;

	@ManyToOne
	@JoinColumn(name = "size_id", nullable = false)
	@JsonIgnoreProperties(value={
			"products, size"
	})
	protected SizeM size;
	
	@OneToMany(mappedBy = "reserve")
	@JsonIgnoreProperties(value={
			"reserve"
	})
	protected List<OrderM> orders;
	
}
