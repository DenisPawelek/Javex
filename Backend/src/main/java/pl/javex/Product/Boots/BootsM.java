package pl.javex.Product.Boots;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.javex.Product.ProductM;

@Entity
@Table(name = "boots")
public class BootsM extends ProductM{
	@Column(name = "tie", columnDefinition = "default false", nullable=false)
	protected boolean hasTie;
}
