package br.com.hsj.ep119.api.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1562124761237449344L;

	public ApplicationException(Throwable _ex) {
		super(_ex);
	}
	
	public ApplicationException(String _msg, Throwable _ex) {
		super(_msg, _ex);
	}
}
