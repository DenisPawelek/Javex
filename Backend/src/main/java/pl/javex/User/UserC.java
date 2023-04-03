package pl.javex.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserC {

	@Autowired
	private UserS userService;
	
	@GetMapping("/users")
	public List<UserM> getUsers(){
		return userService.getAllItems();
	}
	
	
	
	
}
