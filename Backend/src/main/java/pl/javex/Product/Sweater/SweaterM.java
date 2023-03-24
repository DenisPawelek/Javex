package pl.javex.Product.Sweater;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sweaters")
public class SweaterM {

	protected boolean hasGolf;
	protected boolean hasSleeve;
}
