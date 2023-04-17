package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter public class OrderM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@ManyToOne
	@JoinColumn(name = "transaction_id", nullable = false)
	protected TransactionM transaction;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	protected ProductM product;
	
	@Column(name="amount", nullable = false)
	protected Long amount;
	
	@Column(name="price_per_unit_raw", nullable = false)
	protected Long priceUnitRaw;
	
	@Column(name="price_per_unit_discounted", nullable = false)
	protected Long priceUnitDiscounted;
	
	
}
