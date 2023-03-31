package pl.javex.Contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;

@Service
public class ContractS extends MainService<ContractM, ContractR>{

	@Autowired
	private ContractR contractRepository;
	
	
}
