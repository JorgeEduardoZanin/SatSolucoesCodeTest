package sat.solucoes.exception;

import sat.solucoes.exception.enums.ExceptionOrderType;

public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ExceptionOrderType exceptionOrderType;

	public OrderException(ExceptionOrderType exceptionOrderType) {
		super(exceptionOrderType.getMessage());
		this.exceptionOrderType = exceptionOrderType;
	}

	public ExceptionOrderType getExceptionOrderType() {
		return exceptionOrderType;
	}
	
}
