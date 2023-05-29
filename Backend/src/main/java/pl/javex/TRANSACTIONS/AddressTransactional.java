package pl.javex.TRANSACTIONS;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.javex.MODELS.AddressM;
import pl.javex.MODELS.CityM;
import pl.javex.MODELS.PostalCodeM;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTA;

@Component
public class AddressTransactional {

	@Autowired JpaRepository<CityM,			Long> r_city;	
	@Autowired JpaRepository<PostalCodeM,	Long> r_postal;	
	@Autowired JpaRepository<AddressM,		Long> r_address;	
	
	
	@Transactional
	public AddressM addAddress(StructTA addressStruct){

		CityM city = addressStruct.getCity();
		PostalCodeM postal = addressStruct.getPostalCode();
		AddressM address = addressStruct.getAddress();
		
		Example<CityM> cExample = Example.of(city);
		Optional<CityM> cOptional = r_city.findOne(cExample);
		if(cOptional.isEmpty()) {
			city = r_city.save(city);
			postal.setCity(city);
			postal = r_postal.save(postal);	
			address.setPostalCode(postal);
			return r_address.save(address);
		}
		
		city = cOptional.get();
		postal.setCity(city);
		
		Example<PostalCodeM> pExample = Example.of(postal);
		Optional<PostalCodeM> pOptional = r_postal.findOne(pExample);
		if(pOptional.isEmpty()) {postal = r_postal.save(postal);}
		else {postal = pOptional.get();}
		
		address.setPostalCode(postal);
		return r_address.save(address);
	}
	
}
