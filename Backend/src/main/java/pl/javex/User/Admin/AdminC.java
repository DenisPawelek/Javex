package pl.javex.User.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminC {

	
	@Autowired
	private AdminS adminService;
	
	@GetMapping("/admins")
	public List<AdminM> getAdmins(){
		return adminService.getAdmins();
	}
}
