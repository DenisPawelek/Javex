package pl.javex.Firm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.javex.Contract.ContractM;
import pl.javex.User.Admin.Reprezentative.ReprezentativeM;

@Entity
@Table(name = "firms")
public class FirmM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	protected String name;
	protected String desctiption;
	@Column(name = "logourl")
	protected String logo_url;
	
	@OneToOne
	@JoinColumn(name="contract_id")
	protected ContractM contract;
	
	@OneToMany(mappedBy = "firm")
	protected List<ReprezentativeM> reprezentatives;

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getDesctiption() {
		return desctiption;
	}

	protected void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	protected String getLogo_url() {
		return logo_url;
	}

	protected void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	protected ContractM getContract() {
		return contract;
	}

	protected void setContract(ContractM contract) {
		this.contract = contract;
	}

	protected List<ReprezentativeM> getReprezentatives() {
		return reprezentatives;
	}

	protected void setReprezentatives(List<ReprezentativeM> reprezentatives) {
		this.reprezentatives = reprezentatives;
	}
	
	
	
}
