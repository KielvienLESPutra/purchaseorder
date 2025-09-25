package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import org.springframework.stereotype.Service;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.PurchaseOrderHeaderRepository;

@Service
public class PurchaseOrderService {

	private PurchaseOrderHeaderRepository purchaseOrderHeaderRepository;

	public PurchaseOrderService(PurchaseOrderHeaderRepository purchaseOrderHeaderRepository) {
		this.purchaseOrderHeaderRepository = purchaseOrderHeaderRepository;
	}
}
