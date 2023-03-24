package pl.javex.Product.Jacket;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class JacketM {

	protected boolean hasHood;
	protected boolean hasZip;
}
