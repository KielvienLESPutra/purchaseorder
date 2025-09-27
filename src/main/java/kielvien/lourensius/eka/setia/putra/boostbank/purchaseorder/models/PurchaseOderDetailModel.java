package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseOderDetailModel {
	private Integer id;
	private Integer itemId;
	
	@Min(value = 1, message = "cannot less then 1")
	private int itemQty;
	
	private int itemCost;
	private int itemPrice;
}
