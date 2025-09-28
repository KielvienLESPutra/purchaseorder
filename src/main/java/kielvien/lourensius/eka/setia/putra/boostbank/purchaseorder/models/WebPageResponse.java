package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WebPageResponse {
	private Integer currentPage;
	private Integer totalPage;
	private Integer size;
}
