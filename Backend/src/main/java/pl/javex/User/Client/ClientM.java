package pl.javex.User.Client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.Address.AddressM;
import pl.javex.ClientCard.ClientCardM;
import pl.javex.LOG.ClientLogM;

@Entity
@Table(name="clients")
public class ClientM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy ="client")
	private ClientLogM login;
	@ManyToOne
	@JoinColumn(name = "deliveryadress")
	private AddressM delivery_adress;
	
	@OneToOne
	@JoinColumn(name = "card_id")
	private ClientCardM card;
	
	
	
	
	
}
