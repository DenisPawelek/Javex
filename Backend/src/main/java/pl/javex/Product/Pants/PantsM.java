package pl.javex.Product.Pants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.javex.Product.ProductM;

@Entity
@Table(name = "pants")
public class PantsM extends ProductM{
	@Column(name = "long", columnDefinition = "default false", nullable=false)
	protected boolean isLong;
}
