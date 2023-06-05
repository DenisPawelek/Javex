package pl.javex.TRANSACTIONS.__ERROR_TYPES;

public class E_UserNameTaken extends TransactionallError{
	
	public E_UserNameTaken(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
