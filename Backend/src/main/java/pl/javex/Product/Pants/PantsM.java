package pl.javex.Product.Pants;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pants")
public class PantsM {
	protected boolean isLong;
}
