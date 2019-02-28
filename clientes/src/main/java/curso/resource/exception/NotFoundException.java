package curso.resource.exception;

public class NotFoundException extends Exception {

	public NotFoundException() {
		super("NOT FOUND");
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable ex) {
		super("NOT FOUND", ex);
	}

	public NotFoundException(String message, Throwable ex) {
		super(message, ex);
	}

	public NotFoundException(String message, Throwable ex, boolean arg2, boolean arg3) {
		super(message, ex, arg2, arg3);
	}

}
