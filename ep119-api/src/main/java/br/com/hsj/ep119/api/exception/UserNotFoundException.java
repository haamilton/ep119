package br.com.hsj.ep119.api.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1562124761237449344L;

	public UserNotFoundException(String _msg) {
		super(_msg);
	}
	
	public UserNotFoundException(Throwable _ex) {
		super(_ex);
	}
	
	public UserNotFoundException(String _msg, Throwable _ex) {
		super(_msg, _ex);
	}
}
