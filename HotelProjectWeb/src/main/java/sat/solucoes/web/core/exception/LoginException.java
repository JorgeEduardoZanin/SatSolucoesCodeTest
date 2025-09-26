package sat.solucoes.web.core.exception;

import sat.solucoes.web.core.exception.enums.ExceptionLoginType;

public class LoginException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final ExceptionLoginType exceptionLoginType;

	public LoginException(ExceptionLoginType exceptionLoginType) {
		super(exceptionLoginType.getMessage());
		this.exceptionLoginType = exceptionLoginType;
	}

	public ExceptionLoginType getExceptionLoginType() {
		return exceptionLoginType;
	}
	
}
