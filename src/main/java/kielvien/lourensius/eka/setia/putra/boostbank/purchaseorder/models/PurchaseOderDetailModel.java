package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseOderDetailModel {
	private int itemId;
	
	@Min(value = 1, message = "cannot less then 1")
	private int itemQty;
	
	private int itemCost;
	private int itemPrice;
}
