package pl.javex.Size;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SizeC {

	@Autowired
	private SizeS sizeService;
	
	@GetMapping("/sizes")
	public List<SizeM> getSizes(){
		return sizeService.getAllItems();
	}
}
