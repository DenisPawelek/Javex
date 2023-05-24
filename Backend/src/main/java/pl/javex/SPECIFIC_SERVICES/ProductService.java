package pl.javex.SPECIFIC_SERVICES;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.MODELS.ProductM;
import pl.javex.TRANSACTIONS.ProductTransactional;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTP;

import services.GenericService;

@RestController("TransactionalProduct")
@RequestMapping("/T/TP")
public class ProductService{
	
	@Autowired
	public ProductTransactional pt;

	
	@PostMapping("/Product/{type}")
	public List<String> addSingle(
			@PathVariable String type,
			@RequestBody StructTP obj, 
			@RequestParam(required = false) Boolean a, 
			@RequestParam(required = false) Boolean b) 
					throws Exception {
		a = a!=null;
		b = b!=null;
	
		return pt.addSingle(type.toLowerCase(), obj, a, b);
		
		
		
		
	}
	
}
