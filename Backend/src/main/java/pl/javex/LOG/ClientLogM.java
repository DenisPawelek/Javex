package pl.javex.LOG;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.User.Client.ClientM;

@Entity
@Table(name = "clil")
public class ClientLogM {

	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private ClientM client;
	
	private String hash;
	private String name;
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected ClientM getClient() {
		return client;
	}
	protected void setClient(ClientM client) {
		this.client = client;
	}
	protected String getHash() {
		return hash;
	}
	protected void setHash(String hash) {
		this.hash = hash;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	
	
}
