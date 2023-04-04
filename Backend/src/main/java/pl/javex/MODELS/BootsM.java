package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boots")
public class BootsM extends ProductM{
	@Column(name = "tie", nullable=false)
	protected boolean hasTie;
}
