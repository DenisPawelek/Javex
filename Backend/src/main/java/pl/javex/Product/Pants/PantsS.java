package pl.javex.Product.Pants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class PantsS extends MainService<PantsM, PantsR>{

	@Autowired
	private PantsR pantsRepository;
}
