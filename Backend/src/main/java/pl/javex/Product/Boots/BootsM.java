package pl.javex.Product.Boots;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boots")
public class BootsM {
	@Column(name = "tie", columnDefinition = "default false", nullable=false)
	protected boolean hasTie;
}
