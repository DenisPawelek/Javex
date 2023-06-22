package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jackets")
@Getter
@Setter
public class JacketM extends ProductM {
	@Column(name = "hood", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasHood;
	@Column(name = "zip", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasZip;
	@Column(name = "type_name", nullable = true, columnDefinition="varchar(20) default 'Jacket'")
	protected String typeName = "Jacket";
}
