package sat.solucoes.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import sat.solucoes.exception.OrderException;
import sat.solucoes.exception.response.ResponseError;

@RestControllerAdvice
public class OrderExceptionHandler {

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ResponseError> orderException(OrderException orderException, WebRequest webRequest){
		
		var response = new ResponseError(
				orderException.getMessage(),
				orderException.getExceptionOrderType().toString().toUpperCase(),
				orderException.getExceptionOrderType().getHttpStatus().value(),
				LocalDateTime.now(),
				webRequest.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
	}
	
	
}
