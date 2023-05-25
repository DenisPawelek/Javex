package pl.javex.TRANSACTIONS.__ERROR_TYPES;

import java.sql.SQLException;

public class TransactionallError extends SQLException{

	public TransactionallError(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	
}
