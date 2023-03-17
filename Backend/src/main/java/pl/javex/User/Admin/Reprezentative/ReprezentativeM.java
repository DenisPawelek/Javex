package pl.javex.User.Admin.Reprezentative;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

import pl.javex.Address.AddressM;
import pl.javex.Firm.FirmM;
import pl.javex.User.Admin.AdminM;

@Entity
@Table(name ="reprezentatives")
public class ReprezentativeM extends AdminM {

	@ManyToOne
	@JoinColumn(name = "pickupaddress")
	private AddressM pickup_address;
	
	@ManyToOne
	@JoinColumn(name = "firm_id")
	private FirmM firm;

	protected AddressM getPickup_address() {
		return pickup_address;
	}

	protected void setPickup_address(AddressM pickup_address) {
		this.pickup_address = pickup_address;
	}

	protected FirmM getFirm() {
		return firm;
	}

	protected void setFirm(FirmM firm) {
		this.firm = firm;
	}
	
	
	
}
