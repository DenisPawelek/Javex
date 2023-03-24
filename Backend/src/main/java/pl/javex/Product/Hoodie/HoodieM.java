package pl.javex.Product.Hoodie;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hoodies")
public class HoodieM {

	protected boolean hasHood;
	protected boolean hasZip;
}
