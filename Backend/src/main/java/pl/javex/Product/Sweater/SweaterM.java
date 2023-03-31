package pl.javex.Product.Sweater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sweaters")
public class SweaterM {

	
	@Column(name = "golf", columnDefinition = "default false", nullable=false)
	protected boolean hasGolf;	
	@Column(name = "sleve", columnDefinition = "default false", nullable=false)
	protected boolean hasSleeve;
}
