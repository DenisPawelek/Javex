package pl.javex.Product.Hoodie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.Address.AddressM;
import pl.javex.Address.AddressS;

@RestController
public class HoodieC {

	@Autowired
	private HoodieS hoodieService;
	
	@GetMapping("/hoodies")
	public List<HoodieM> getHoodies(){
		return hoodieService.getAllItems();
	}
}
