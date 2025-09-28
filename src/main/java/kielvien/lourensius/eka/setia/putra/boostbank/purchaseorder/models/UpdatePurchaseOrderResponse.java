package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UpdatePurchaseOrderResponse {
	private String description;
	private LocalDateTime dateTime;
	private int totalPrice;
	private int totalCost;
	private List<PurchaseOderDetailModel> purchaseOrderDetails;
}
