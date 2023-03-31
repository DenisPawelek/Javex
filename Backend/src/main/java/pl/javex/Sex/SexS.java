package pl.javex.Sex;

import org.springframework.beans.factory.annotation.Autowired;

import services.MainService;

public class SexS extends MainService<SexM, SexR>{

	@Autowired
	private SexR sexRepository;
}
