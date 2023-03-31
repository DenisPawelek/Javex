package pl.javex.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.MainService;


@Service
public class UserS extends MainService<UserM, UserR>{

	@Autowired
	private UserR userRepository;
	
}
