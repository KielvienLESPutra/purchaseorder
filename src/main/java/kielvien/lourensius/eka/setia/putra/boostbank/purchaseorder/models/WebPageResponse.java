package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebPageResponse {
	private Integer currentPage;
	private Integer totalPage;
	private Integer size;
}
