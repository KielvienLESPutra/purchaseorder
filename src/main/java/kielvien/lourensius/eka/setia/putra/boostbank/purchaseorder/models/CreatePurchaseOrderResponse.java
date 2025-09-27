package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePurchaseOrderResponse {
	private Integer id;
	private String description;
	private int totalPrice;
	private int totalCost;
	private List<PurchaseOderDetailModel> purchaseOrderDetails;
}
