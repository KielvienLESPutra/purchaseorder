package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOderDetailModel {
	private Integer id;
	private int itemId;
	
	@Min(value = 1, message = "cannot less then 1")
	private int itemQty;
	
	private int itemCost;
	private int itemPrice;
}
