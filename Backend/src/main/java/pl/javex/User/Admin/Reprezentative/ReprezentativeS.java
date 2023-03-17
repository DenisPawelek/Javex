package pl.javex.User.Admin.Reprezentative;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReprezentativeS {

	@Autowired
	private ReprezentativeR reprRepository;
	
	public List<ReprezentativeM> getReprs(){
		return reprRepository.findAll();
	}
	
}
