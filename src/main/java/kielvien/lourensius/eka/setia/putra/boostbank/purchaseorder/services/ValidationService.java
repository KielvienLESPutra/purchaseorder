package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class ValidationService {

	private Validator validator;

	public ValidationService(Validator validator) {
		this.validator = validator;
	}
	
	public void validate(Object request) {
		Set<ConstraintViolation<Object>> constrainViolations = validator.validate(request);
		if(!constrainViolations.isEmpty()) {
			throw new ConstraintViolationException(constrainViolations);
		}
	}
}
