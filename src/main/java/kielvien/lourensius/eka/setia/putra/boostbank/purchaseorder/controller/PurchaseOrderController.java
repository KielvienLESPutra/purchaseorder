package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services.PurchaseOrderService;

@RestController
@RequestMapping(path = "/api/po")
public class PurchaseOrderController {
	private PurchaseOrderService orderService;

	public PurchaseOrderController(PurchaseOrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<CreatePurchaseOrderResponse> createPurchaseOrder(
			@RequestBody CreatePurchaseOrderRequest request) {
		CreatePurchaseOrderResponse response = orderService.createPurchaseOrder(request);

		return WebResponse.<CreatePurchaseOrderResponse>builder().data(response)
				.statusCode(Constants.statusCode.OK.getCode()).desc(Constants.statusCode.OK.getDesc()).build();
	}
}
