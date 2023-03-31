package pl.javex.Description;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DescriptionC {

	@Autowired
	private DescriptionS descriptionService;
	
	@GetMapping("/descriptions")
	public List<DescriptionM> getDescriptions(){
		return descriptionService.getAllItems();
	}
}
