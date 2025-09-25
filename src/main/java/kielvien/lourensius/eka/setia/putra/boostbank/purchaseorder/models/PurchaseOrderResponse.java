package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import java.util.List;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderDetail;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseOrderResponse {
	private String description;
	private int totalPrice;
	private int totalCost;
	private List<PurchaseOrderDetail> purchaseOrderDetails;
}
