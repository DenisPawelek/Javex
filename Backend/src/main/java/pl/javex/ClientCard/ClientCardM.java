package pl.javex.ClientCard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.javex.User.Client.ClientM;

@Entity
public class ClientCardM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private long spendMoney;
	private long giftCardMoney;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private CardStatusM status;
	
	@OneToOne(mappedBy="card")
	private ClientM client;

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected long getSpendMoney() {
		return spendMoney;
	}

	protected void setSpendMoney(long spendMoney) {
		this.spendMoney = spendMoney;
	}

	protected long getGiftCardMoney() {
		return giftCardMoney;
	}

	protected void setGiftCardMoney(long giftCardMoney) {
		this.giftCardMoney = giftCardMoney;
	}

	protected CardStatusM getStatus() {
		return status;
	}

	protected void setStatus(CardStatusM status) {
		this.status = status;
	}

	protected ClientM getClient() {
		return client;
	}

	protected void setClient(ClientM client) {
		this.client = client;
	}
	
	
	
	
}
