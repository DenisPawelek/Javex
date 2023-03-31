package pl.javex.Product.Hoodie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class HoodieS extends MainService<HoodieM, HoodieR>{

	@Autowired
	private HoodieR hoodieRepository;
}
