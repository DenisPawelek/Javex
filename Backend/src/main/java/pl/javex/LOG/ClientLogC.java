package pl.javex.LOG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientLogC {

	@Autowired
	private ClientLogS clogService;
	
	@GetMapping("/clogs")
	public List<ClientLogM> getClogs(){
		return clogService.getCLogs();
	}
	
}
