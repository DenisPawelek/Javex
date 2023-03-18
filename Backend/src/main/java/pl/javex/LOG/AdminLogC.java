package pl.javex.LOG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLogC {

	@Autowired
	private AdminLogS alogService;
	
	@GetMapping("/alogs")
	public List<AdminLogM> getAlogs(){
		return alogService.getAlogs();
	}
}
