package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hoodies")
public class HoodieM extends ProductM {
	@Column(name = "hood", columnDefinition = "default false", nullable=false)
	protected boolean hasHood;	
	@Column(name = "zip", columnDefinition = "default false", nullable=false)
	protected boolean hasZip;
}
