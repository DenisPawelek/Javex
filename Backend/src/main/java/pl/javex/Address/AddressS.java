package pl.javex.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressS {

	@Autowired
	private AddressR addressRepository;
	
	public List<AddressM> getAddresses(){
		return addressRepository.findAll();
	}
	
}
