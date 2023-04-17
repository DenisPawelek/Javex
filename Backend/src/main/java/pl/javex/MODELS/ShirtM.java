package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shirts")
@Getter @Setter public class ShirtM extends ProductM{
	
	@Column(name = "sleve", columnDefinition = "default false", nullable=false)
	protected boolean hasSleeve;
	@Column(name = "print", columnDefinition = "default false", nullable=false)
	protected boolean hasPrint;
}
