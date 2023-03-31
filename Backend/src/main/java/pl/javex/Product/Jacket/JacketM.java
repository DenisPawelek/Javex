package pl.javex.Product.Jacket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.javex.Product.ProductM;

@Entity
@Table(name = "admins")
public class JacketM extends ProductM{
	@Column(name = "hood", columnDefinition = "default false", nullable=false)
	protected boolean hasHood;
	@Column(name = "zip", columnDefinition = "default false", nullable=false)
	protected boolean hasZip;
}
