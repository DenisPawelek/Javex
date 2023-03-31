package pl.javex.Product.Pants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pants")
public class PantsM {
	@Column(name = "long", columnDefinition = "default false", nullable=false)
	protected boolean isLong;
}
