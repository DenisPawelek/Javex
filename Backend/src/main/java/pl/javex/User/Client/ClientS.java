package pl.javex.User.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientS {

	@Autowired
	private ClientR clientRepository;
	
	public List<ClientM> getClients(){
		return clientRepository.findAll();
	}
}
