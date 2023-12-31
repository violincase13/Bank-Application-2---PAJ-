//package com.luxoft.bankapp.exceptions;
//
//public class ClientExistsException extends BankException {
//	private static final long serialVersionUID = -8368249553360028667L;
//
//	public ClientExistsException(String message) {
//		super(message);
//	}
//
//}

//exercise 3

package com.luxoft.bankapp.exceptions;

public class ClientExistsException extends RuntimeException {
	private static final long serialVersionUID = -8368249553360028667L;

	public ClientExistsException(String message) {
		super(message);
	}
}

