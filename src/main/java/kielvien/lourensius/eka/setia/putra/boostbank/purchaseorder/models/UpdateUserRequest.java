package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequest {
	@NotBlank(message = "cannot be null or empty")
	@Size(max = 500, message = "character cannot more then 500")
	private String firstName;

	@NotBlank(message = "cannot be null or empty")
	@Size(max = 500, message = "character cannot more then 500")
	private String lastName;

	@NotBlank(message = "cannot be null or empty")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "pattern is invalid")
	private String email;

	@NotBlank(message = "cannot be null or empty")
	@Pattern(regexp = "^(\\+62|62|0)8[1-9][\\d]{6,9}$", message = "pattern is invalid")
	private String phone;
}
