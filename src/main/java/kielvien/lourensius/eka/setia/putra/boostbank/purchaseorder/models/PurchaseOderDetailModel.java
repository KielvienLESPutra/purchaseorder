package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseOderDetailModel {
	private int itemId;
	private int itemQty;
	private int itemCost;
	private int itemPrice;
}
