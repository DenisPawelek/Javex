package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sweaters")
@Getter
@Setter
public class SweaterM extends ProductM {

	@Column(name = "golf", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasGolf;
	@Column(name = "sleve", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasSleeve;
}
