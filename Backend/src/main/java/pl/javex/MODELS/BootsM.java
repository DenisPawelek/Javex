package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boots")
@Getter
@Setter
public class BootsM extends ProductM {
	@Column(name = "tie", nullable = false)
	protected Boolean hasTie;
	
	@Column(name = "type_name", nullable = true, columnDefinition="varchar(20) default 'Boots'")
	protected String typeName = "Boots";
}
