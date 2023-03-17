package pl.javex.User.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminS {

	@Autowired
	private AdminR adminRepository;
	
	public List<AdminM> getAdmins(){
		return adminRepository.findAll();
	}
}
