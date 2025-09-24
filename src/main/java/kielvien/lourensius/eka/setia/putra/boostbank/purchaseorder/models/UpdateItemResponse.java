package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateItemResponse {
	private String name;
	private String description;
	private int price;
	private int cost;
}
