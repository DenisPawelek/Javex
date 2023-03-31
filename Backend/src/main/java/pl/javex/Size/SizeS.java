package pl.javex.Size;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class SizeS extends MainService<SizeM, SizeR>{

	@Autowired
	private SizeR sizeRepository;
}
