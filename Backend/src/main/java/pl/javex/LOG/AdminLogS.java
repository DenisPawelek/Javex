package pl.javex.LOG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLogS {

	@Autowired
	private AdminLogR alogRepository;
	
	public List<AdminLogM> getAlogs(){
		return alogRepository.findAll();
	}
	
}
