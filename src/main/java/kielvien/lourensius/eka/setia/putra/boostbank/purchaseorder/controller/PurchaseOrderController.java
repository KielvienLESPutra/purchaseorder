package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services.PurchaseOrderService;

@RestController
@RequestMapping(path = "/api/po")
public class PurchaseOrderController {
	private PurchaseOrderService orderService;

	public PurchaseOrderController(PurchaseOrderService orderService) {
		this.orderService = orderService;
	}
}
