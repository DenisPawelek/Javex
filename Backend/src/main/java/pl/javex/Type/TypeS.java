package pl.javex.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class TypeS extends MainService<TypeM, TypeR>{

	@Autowired TypeR typeRepository;
}
