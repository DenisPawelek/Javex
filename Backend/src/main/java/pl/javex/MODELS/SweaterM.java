package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sweaters")
@Getter @Setter public class SweaterM extends ProductM{

	
	@Column(name = "golf", columnDefinition = "default false", nullable=false)
	protected boolean hasGolf;	
	@Column(name = "sleve", columnDefinition = "default false", nullable=false)
	protected boolean hasSleeve;
}
