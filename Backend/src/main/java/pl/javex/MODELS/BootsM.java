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
	protected boolean hasTie;
}
