package pl.javex.User.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientC {

	@Autowired
	private ClientS clientService;
	
	@GetMapping("/clients")
	public List<ClientM> getClients(){
		return clientService.getClients();
	}
	
}
