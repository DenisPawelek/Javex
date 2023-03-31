package pl.javex.Product.Boots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class BootsS  extends MainService<BootsM, BootsR>{

	@Autowired
	private BootsR bootsRepository;
}