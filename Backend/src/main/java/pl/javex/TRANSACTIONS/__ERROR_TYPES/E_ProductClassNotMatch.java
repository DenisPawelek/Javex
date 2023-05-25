package pl.javex.TRANSACTIONS.__ERROR_TYPES;

public class E_ProductClassNotMatch extends TransactionallError{

	public E_ProductClassNotMatch(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
