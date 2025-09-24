package sat.solucoes.exception.enums;

import org.springframework.http.HttpStatus;

public enum ExceptionOrderType {

	VALUE_MUST_BE_GREATER_THAN_ZERO("O valor do produto nao pode ser menor que zero!", HttpStatus.BAD_REQUEST);
	
	private String message;
	private HttpStatus httpStatus;
	
	private ExceptionOrderType(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
