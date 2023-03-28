package pl.javex.Product.Shirt;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shirts")
public class ShirtM {

	protected boolean hasSleeve;
	protected boolean hasPrint;
}
