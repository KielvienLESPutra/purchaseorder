package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateItemRequest {
	@NotBlank(message = "cannot be null or empty")
	@Size(max = 500, message = "character cannot more then 500")
	private String name;

	@NotBlank(message = "cannot be null or empty")
	@Size(max = 500, message = "character cannot more then 500")
	private String description;

	@Min(value = 1, message = "cannot less then 1")
	@Pattern(regexp = "^\\d*$", message = "pattern is invalid")
	private int price;

	@Min(value = 1, message = "cannot less then 1")
	@Pattern(regexp = "^\\d*$", message = "pattern is invalid")
	private int cost;
}
