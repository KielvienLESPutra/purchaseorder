package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderDetail;
import lombok.Data;

@Data
public class PurchaseOrderRequest {
	@NotBlank(message = "cannot be null or empty")
	@Size(max = 500, message = "character cannot more then 500")
	private String description;

	@NotBlank(message = "cannot be null or empty")
	@Size(min = 1, message = "purchase order detail must be at least 1")
	private List<PurchaseOrderDetail> purchaseOrderDetails;
}
