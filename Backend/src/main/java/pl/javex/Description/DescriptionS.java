package pl.javex.Description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class DescriptionS extends MainService<DescriptionM, DescriptionR> {

	@Autowired
	private DescriptionR descriptionRepository;
}
