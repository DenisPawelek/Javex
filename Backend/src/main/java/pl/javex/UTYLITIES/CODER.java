package pl.javex.UTYLITIES;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CODER {

	private static CODER _instance;
	private PasswordEncoder coder;
	
	
	
	private CODER() {
		coder = new BCryptPasswordEncoder();
	}
	
	public static CODER _GET_INSTANCE() {
		if(_instance==(null)) {
			_instance = new CODER();
		} 
		return _instance; 
	}
	
	public PasswordEncoder getCoder() {
		return this.coder;
	}
	
}
