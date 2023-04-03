package pl.javex.Brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandC {

	@Autowired
	private BrandS brandService;
	
	@GetMapping("/brands")
	public List<BrandM> getBrands(){
		return brandService.getAllItems();
	}
}
