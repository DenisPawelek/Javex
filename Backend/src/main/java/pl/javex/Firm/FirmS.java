package pl.javex.Firm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmS {

	@Autowired
	private FirmR firmRepository;
	
	public List<FirmM> getFirms(){
		return firmRepository.findAll();
	}
	
}
