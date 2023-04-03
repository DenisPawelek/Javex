package pl.javex.Sex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SexC {

	@Autowired
	private SexS sexService;
	
	@GetMapping("/sexes")
	public List<SexM> getSexes(){
		return sexService.getAllItems();
	}
}
