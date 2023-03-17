package pl.javex.ClientCard;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CardStatusM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private int discountValue;
	
	@OneToMany(mappedBy = "status")
	private List<ClientCardM> cards;

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}


	protected List<ClientCardM> getCards() {
		return cards;
	}

	protected void setCards(List<ClientCardM> cards) {
		this.cards = cards;
	}
	

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getDiscountValue() {
		return discountValue;
	}

	protected void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}
	
	
	
}
