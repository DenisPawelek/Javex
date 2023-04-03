package pl.javex.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class MaterialS extends MainService<MaterialM, MaterialR>{

	@Autowired
	private MaterialR materialRepository;
}
