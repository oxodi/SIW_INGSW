package persistence;

public class PersistenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PersistenceException(String message) {
		System.out.println(message);
		//super(message);
	}

	public PersistenceException(Throwable cause) {
		//super(cause);
		System.out.println(cause);
	}

	public PersistenceException(String message, Throwable cause) {
		//super(message, cause);
		System.out.println(message + cause);
	}
}
