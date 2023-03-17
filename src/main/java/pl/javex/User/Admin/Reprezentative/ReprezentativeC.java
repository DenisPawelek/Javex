package pl.javex.User.Admin.Reprezentative;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReprezentativeC {

	@Autowired
	private ReprezentativeS reprService;
	
	@GetMapping("/reprezentatives")
	public List<ReprezentativeM> getReprs(){
		return reprService.getReprs();
	}
	
}
