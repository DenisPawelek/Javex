package pl.javex.TRANSACTIONS.__ERROR_TYPES;

public class E_EmailAlreadyTaken extends TransactionallError{

	public E_EmailAlreadyTaken(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
