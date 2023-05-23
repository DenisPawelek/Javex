package pl.javex.SPECIFIC_SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.javex.TRANSACTIONS.TransactionTransactional;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTT;

@RestController("TransactionalTransaction")
@RequestMapping("/T/TT")
public class TransactionService {

	@Autowired
	public TransactionTransactional tt;
	
	@PostMapping("/Transaction")
	public List<String> addSingle(@RequestBody StructTT obj) throws Exception{
		return tt.tryRegisterTransaction(obj);
	}
	
}
