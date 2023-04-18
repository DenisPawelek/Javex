package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pants")
@Getter
@Setter
public class PantsM extends ProductM {
	@Column(name = "longsleeve", columnDefinition = "boolean default false", nullable = false)
	protected Boolean isLong;
}
