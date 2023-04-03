package pl.javex.Product;

import org.springframework.beans.factory.annotation.Autowired;

import services.MainService;

public class ProductS extends MainService<ProductM, ProductR> {

	@Autowired
	private ProductR productRepository;
}
