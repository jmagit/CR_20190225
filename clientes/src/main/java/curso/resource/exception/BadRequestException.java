package curso.resource.exception;

public class BadRequestException extends Exception {

	public BadRequestException() {
		super("BAD REQUEST");
	}

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable ex) {
		super("BAD REQUEST", ex);
	}

	public BadRequestException(String message, Throwable ex) {
		super(message, ex);
	}

	public BadRequestException(String message, Throwable ex, boolean arg2, boolean arg3) {
		super(message, ex, arg2, arg3);
	}

}
