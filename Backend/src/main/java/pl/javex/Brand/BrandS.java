package pl.javex.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class BrandS extends MainService<BrandM, BrandR>{
	
	@Autowired
	private BrandR brandRepository;

}
