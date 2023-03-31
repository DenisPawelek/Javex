package pl.javex.Product.Shirt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class ShirtS extends MainService<ShirtM, ShirtR>{

	@Autowired
	private ShirtR shirtRepository;
}
