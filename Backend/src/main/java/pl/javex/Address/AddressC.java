package pl.javex.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressC {

	@Autowired
	private AddressS addressService;
	
	@GetMapping("/adresses")
	public List<AddressM> getAddresses(){
		return addressService.getAllItems();
	}
}
