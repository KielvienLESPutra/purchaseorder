package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePurchaseOrderRequest {
	@NotBlank(message = "cannot be null or empty")
	@Size(max = 500, message = "character cannot more then 500")
	private String description;

	@NotBlank(message = "cannot be null or empty")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}(:\\d{2})?$", message = "Date must be in format yyyy-MM-ddTHH:mm[:ss]")
	private String dateTime;

	@Valid
	@NotNull(message = "cannot be null")
	@Size(min = 1, message = "purchase order detail must be at least 1")
	private List<PurchaseOderDetailModel> purchaseOrderDetails;
}
