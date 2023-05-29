package pl.javex.TRANSACTIONS.__ERROR_TYPES;

public class E_NoSuchProductReserve extends TransactionallError{

	public E_NoSuchProductReserve(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
