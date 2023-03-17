package pl.javex.Contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractS {

	@Autowired
	private ContractR contractRepository;
	
	public List<ContractM> getContracts(){
		return contractRepository.findAll();
	}
	
}
