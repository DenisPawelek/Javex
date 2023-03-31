package pl.javex.Product.Sweater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class SweaterS extends MainService<SweaterM, SweaterR>{

	@Autowired
	private SweaterR sweaterRepository;
}
