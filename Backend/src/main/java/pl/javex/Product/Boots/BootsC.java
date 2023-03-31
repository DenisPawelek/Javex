package pl.javex.Product.Boots;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootsC {

	@Autowired
	private BootsS bootsService;
	
	@GetMapping("/boots")
	public List<BootsM> getBoots(){
		return bootsService.getAllItems();
	}
}
