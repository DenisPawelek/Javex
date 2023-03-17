package pl.javex.User.Admin.StdAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StdAdminC {

	@Autowired
	private StdAdminS stdaService;
	
	@GetMapping("/stdadmins")
	public List<StdAdminM> getStdas(){
		return stdaService.getStdas();
	}
}
