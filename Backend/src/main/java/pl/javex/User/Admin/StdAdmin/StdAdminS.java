package pl.javex.User.Admin.StdAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StdAdminS {

	@Autowired
	private StdAdminR stdaRepository;
	
	public List<StdAdminM> getStdas(){
		return stdaRepository.findAll();
	}
	
}
