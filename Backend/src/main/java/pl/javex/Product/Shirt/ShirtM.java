package pl.javex.Product.Shirt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shirts")
public class ShirtM {
	
	@Column(name = "sleve", columnDefinition = "default false", nullable=false)
	protected boolean hasSleeve;
	@Column(name = "print", columnDefinition = "default false", nullable=false)
	protected boolean hasPrint;
}
