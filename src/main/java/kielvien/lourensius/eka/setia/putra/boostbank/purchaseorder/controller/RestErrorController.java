package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ConstraintViolationException;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;

@RestControllerAdvice
public class RestErrorController {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<WebResponse<Object>> constrainViolationException(ConstraintViolationException exception) {
		WebResponse<Object> response = WebResponse.builder().data(null)
				.statusCode(Constants.statusCode.BAD_REQUEST.getCode()).desc(exception.getMessage()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<WebResponse<Object>> responseStatusException(ResponseStatusException exception) {
		WebResponse<Object> response = WebResponse.builder().data(null)
				.statusCode(Constants.statusCode.NOT_FOUND.getCode()).desc(exception.getReason()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
