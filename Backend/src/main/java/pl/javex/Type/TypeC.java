package pl.javex.Type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.Address.AddressM;
import pl.javex.Address.AddressS;

@RestController
public class TypeC {
	
	@Autowired
	private TypeS typService;
	
	@GetMapping("/types")
	public List<TypeM> getTypes(){
		return typService.getAllItems();
	}

}
