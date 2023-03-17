package pl.javex.Contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractC {

	@Autowired
	private ContractS contractService;
	
	@GetMapping("/contracts")
	public List<ContractM> getContracts(){
		return contractService.getContracts();
	}
	
}
