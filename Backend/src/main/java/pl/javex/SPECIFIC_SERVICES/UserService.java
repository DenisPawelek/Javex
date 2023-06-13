package pl.javex.SPECIFIC_SERVICES;

import java.security.Principal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.MODELS.UserM;
import pl.javex.TRANSACTIONS.AddressTransactional;
import pl.javex.TRANSACTIONS.UserTransactional;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTP;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTU;

import pl.javex.UTYLITIES.CODER;

@RestController("TransactionalUser")
@RequestMapping("/T/TU")
public class UserService implements UserDetailsService{

	@Autowired
	public UserTransactional ut;
	
	@Autowired
	JpaRepository<UserM, Long> r_user;	

	@GetMapping("/bcrypt")
	public String bcryptPassword(Principal authenticatedUser){
		return new BCryptPasswordEncoder().encode("password")+"   "+authenticatedUser.getName();
	}

	@PostMapping("/register")
	public List<String> addSingle(@RequestBody StructTU obj) throws Exception{
		return ut.tryRegister(obj);		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserM user = new UserM();
		user.setUsername(username);
		Example<UserM> userExample = Example.of(user, ExampleMatcher.matchingAny());
		Optional<UserM> userOptional;
		
		if(r_user.exists(userExample)) {
			userOptional = r_user.findOne(userExample);
			if(userOptional.isPresent())
				return userOptional.get();
		}
		
		
		return null;
	}
}
