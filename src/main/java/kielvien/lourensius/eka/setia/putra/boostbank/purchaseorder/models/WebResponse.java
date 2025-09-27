package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WebResponse<T> {
	private T data;
	private String statusCode;
	private String desc;
	private WebPageResponse paging;
}
