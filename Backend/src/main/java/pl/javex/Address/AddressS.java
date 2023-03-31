package pl.javex.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class AddressS extends MainService<AddressM, AddressR> {

	@Autowired
	private AddressR addressRepository;
	
	
}
