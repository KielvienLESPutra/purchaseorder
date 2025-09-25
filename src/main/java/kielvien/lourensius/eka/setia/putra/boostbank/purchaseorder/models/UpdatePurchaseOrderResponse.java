package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePurchaseOrderResponse {
	private String description;
	private int totalPrice;
	private int totalCost;
	private List<PurchaseOderDetailModel> purchaseOrderDetails;
}
