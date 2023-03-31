package pl.javex.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductC {
	
	@Autowired
	private ProductS productService;
	
	@GetMapping("/products")
	public List<ProductM> getProducts(){
		return productService.getAllItems();

	}
}