package pl.javex.TRANSACTIONS.__ERROR_TYPES;

public class E_NoSuchUser extends TransactionallError {

	public E_NoSuchUser(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
