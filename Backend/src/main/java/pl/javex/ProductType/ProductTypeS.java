package pl.javex.ProductType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class ProductTypeS extends MainService<ProductTypeM, ProductTypeR>{

	@Autowired
	private ProductTypeR productTypeRepository;
}
