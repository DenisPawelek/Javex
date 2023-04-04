package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pants")
public class PantsM extends ProductM{
	@Column(name = "long", columnDefinition = "default false", nullable=false)
	protected boolean isLong;
}
