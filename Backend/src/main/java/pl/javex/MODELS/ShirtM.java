package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shirts")
@Getter
@Setter
public class ShirtM extends ProductM {

	@Column(name = "sleve", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasSleeve;
	@Column(name = "print", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasPrint;
	@Column(name = "type_name", nullable = true, columnDefinition="varchar(20) default 'Shirt'")
	protected String typeName = "Shirt";
}
