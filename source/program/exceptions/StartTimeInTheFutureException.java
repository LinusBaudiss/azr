package program.exceptions;

public class StartTimeInTheFutureException extends Exception {

	private static final long serialVersionUID = 1L;

	public StartTimeInTheFutureException() {
		super();
	}

	public StartTimeInTheFutureException(String string) {
		super(string);
	}

}
