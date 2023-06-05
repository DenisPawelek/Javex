package pl.javex.SPECIFIC_SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.TRANSACTIONS.AddressTransactional;
import pl.javex.TRANSACTIONS.UserTransactional;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTP;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTU;

@RestController("TransactionalUser")
@RequestMapping("/T/TU")
public class UserService {

	@Autowired
	public UserTransactional ut;
	
	@PostMapping("/User")
	public List<String> addSingle(@RequestBody StructTU obj) throws Exception{
		return ut.tryRegister(obj);		
	}
}
