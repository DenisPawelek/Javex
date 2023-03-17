package pl.javex.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserS {

	@Autowired
	private UserR userRepository;
	
	public List<UserM> getUsers(){
		return userRepository.findAll();
	}
	
}
