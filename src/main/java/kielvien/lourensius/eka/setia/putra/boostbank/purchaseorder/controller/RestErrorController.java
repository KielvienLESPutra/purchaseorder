package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ConstraintViolationException;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestErrorController {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<WebResponse<Object>> constrainViolationException(ConstraintViolationException exception) {
		log.warn("Warning validation request fail for {}", exception.getMessage());
		WebResponse<Object> response = WebResponse.builder().data(null)
				.statusCode(Constants.statusCode.BAD_REQUEST.getCode()).desc(exception.getMessage()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<WebResponse<Object>> responseStatusException(ResponseStatusException exception) {
		log.warn("Warning response proses fail with message : {}", exception.getMessage());
		if (HttpStatus.BAD_REQUEST.equals(exception.getStatusCode())) {
			WebResponse<Object> response = WebResponse.builder().data(null)
					.statusCode(Constants.statusCode.BAD_REQUEST.getCode()).desc(exception.getReason()).build();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		} else {
			WebResponse<Object> response = WebResponse.builder().data(null)
					.statusCode(Constants.statusCode.NOT_FOUND.getCode()).desc(exception.getReason()).build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<WebResponse<Object>> generalException(Exception exception) {
		exception.printStackTrace();
		log.error("Error message {}", exception.getMessage());

		WebResponse<Object> response = WebResponse.builder().data(null)
				.statusCode(Constants.statusCode.GENERAL_ERROR.getCode())
				.desc(Constants.statusCode.GENERAL_ERROR.getDesc()).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
