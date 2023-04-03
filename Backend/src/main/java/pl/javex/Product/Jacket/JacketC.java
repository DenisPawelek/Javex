package pl.javex.Product.Jacket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.Address.AddressM;
import pl.javex.Address.AddressS;

@RestController
public class JacketC {
	
	@Autowired
	private JacketS jacketService;
	
	@GetMapping("/jackets")
	public List<JacketM> getJackets(){
		return jacketService.getAllItems();
	}
}
