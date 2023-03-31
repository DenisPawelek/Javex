package pl.javex.Product.Jacket;

import org.springframework.beans.factory.annotation.Autowired;

import services.MainService;

public class JacketS extends MainService<JacketM, JacketR>{

	@Autowired
	private JacketR jacketRepository;
}
