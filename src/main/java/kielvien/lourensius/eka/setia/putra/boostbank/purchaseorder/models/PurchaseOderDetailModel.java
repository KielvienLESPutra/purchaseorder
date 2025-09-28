package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PurchaseOderDetailModel {
	private Integer id;
	
	@NotNull(message = "cannot be null")
	private Integer itemId;
	
	@NotNull(message = "cannot be null")
	@Min(value = 1, message = "cannot less then 1")
	private int itemQty;
	
	private Integer itemCost;
	private Integer itemPrice;
}
