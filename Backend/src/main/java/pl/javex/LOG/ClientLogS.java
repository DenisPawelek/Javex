package pl.javex.LOG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLogS {

	@Autowired
	private ClientLogR clogRepository;
	
	public List<ClientLogM> getCLogs(){
		return clogRepository.findAll();
	}
	
}
