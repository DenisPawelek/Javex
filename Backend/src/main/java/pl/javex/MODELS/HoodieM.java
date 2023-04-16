package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hoodies")
@Getter @Setter public class HoodieM extends ProductM {
	@Column(name = "hood", columnDefinition = "default false", nullable=false)
	protected boolean hasHood;	
	@Column(name = "zip", columnDefinition = "default false", nullable=false)
	protected boolean hasZip;
}
