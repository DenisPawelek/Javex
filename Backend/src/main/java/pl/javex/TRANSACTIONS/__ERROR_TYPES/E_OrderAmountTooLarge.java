package pl.javex.TRANSACTIONS.__ERROR_TYPES;

public class E_OrderAmountTooLarge extends TransactionallError{

	public E_OrderAmountTooLarge(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
