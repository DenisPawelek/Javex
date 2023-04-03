package pl.javex.ProductType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.Address.AddressM;
import pl.javex.Address.AddressS;

@RestController
public class ProductTypeC {

	@Autowired
	private ProductTypeS productTypeService;
	
	@GetMapping("/productTypes")
	public List<ProductTypeM> getProductTypes(){
		return productTypeService.getAllItems();
	}
}
