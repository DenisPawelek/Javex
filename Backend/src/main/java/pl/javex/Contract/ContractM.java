package pl.javex.Contract;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contracts")
public class ContractM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private float margin;

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected float getMargin() {
		return margin;
	}

	protected void setMargin(float margin) {
		this.margin = margin;
	}
}
