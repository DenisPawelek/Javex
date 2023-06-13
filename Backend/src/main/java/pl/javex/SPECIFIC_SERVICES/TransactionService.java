package pl.javex.SPECIFIC_SERVICES;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_NoSuchUser;

import pl.javex.TRANSACTIONS.TransactionTransactional;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTT;
import pl.javex.MODELS.UserM;
@RestController("TransactionalTransaction")
@RequestMapping("/T/TT")
public class TransactionService {

	@Autowired
	public TransactionTransactional tt;
	@Autowired JpaRepository<UserM,			Long> r_user;
	
	@PostMapping("/Transaction")
	public List<String> addSingle(@RequestBody StructTT obj, Principal authenticatedUser) throws Exception{
//		UserM user = new UserM();
//		user.setUsername(authenticatedUser.getName());
//		Example<UserM> userExample = Example.of(user, ExampleMatcher.matchingAny());
//		Optional<UserM> userOptional = r_user.findById(transactionStruct.getUser().getId());
//		
//		if(userOptional.isEmpty()) { throw new E_NoSuchUser("User undefined", new Exception());}
//		
//		
//		List<String> ss = new ArrayList<String>();
//		
//		List<String> ss = new ArrayList<String>();
//		ss.add(authenticatedUser.getName());
	
		UserM user = new UserM();
		
		user.setUsername(authenticatedUser.getName());
		
		Example<UserM> userExample = Example.of(user, ExampleMatcher.matchingAny());
		Optional<UserM> userOptional = r_user.findOne(userExample);
		if(!userOptional.isPresent()){throw new E_NoSuchUser("User undefined", new Exception());}
//		
		user = userOptional.get();
//		ss.add(user.getName());
//		ss.add(user.getPassword());
//		ss.add(user.getId().toString());
//		return ss;
		
		return tt.tryRegisterTransaction(userOptional.get(), obj);
	}
	
}
