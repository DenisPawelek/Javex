package pl.javex.Product.Sweater;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.Address.AddressM;
import pl.javex.Address.AddressS;

@RestController
public class SweaterC {

	@Autowired
	private SweaterS sweaterService;
	
	@GetMapping("/sweaters")
	public List<SweaterM> getSweaters(){
		return sweaterService.getAllItems();
	}
}
