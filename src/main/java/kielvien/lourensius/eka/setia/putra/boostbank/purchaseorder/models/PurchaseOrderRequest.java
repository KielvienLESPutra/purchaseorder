package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import java.util.List;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderDetail;
import lombok.Data;

@Data
public class PurchaseOrderRequest {
	private String description;
	private List<PurchaseOrderDetail> purchaseOrderDetails;
}
