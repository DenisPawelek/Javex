package pl.javex.Product.Pants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.Address.AddressM;
import pl.javex.Address.AddressS;

@RestController
public class PantsC {

	@Autowired
	private PantsS pantsService;
	
	@GetMapping("/pants")
	public List<PantsM> getPants(){
		return pantsService.getAllItems();
	}
}
