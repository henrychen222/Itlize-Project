
public class LoginFaliedException extends Exception 
{

	public LoginFaliedException() {
		System.err.println("Provided username/password is invalid");
	}

	public LoginFaliedException(String message) {
		super(message);
	}

	public LoginFaliedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public LoginFaliedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LoginFaliedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
