package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Items;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderDetail;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderHeader;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.PurchaseOderDetailModel;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.PurchaseOrderHeaderRepository;

@Service
public class PurchaseOrderService {

	private PurchaseOrderHeaderRepository purchaseOrderHeaderRepository;
	private ItemService itemService;
	private ValidationService validationService;

	public PurchaseOrderService(PurchaseOrderHeaderRepository purchaseOrderHeaderRepository, ItemService itemService,
			ValidationService validationService) {
		this.purchaseOrderHeaderRepository = purchaseOrderHeaderRepository;
		this.itemService = itemService;
		this.validationService = validationService;
	}

	@Transactional
	public CreatePurchaseOrderResponse createPurchaseOrder(CreatePurchaseOrderRequest request) {
		validationService.validate(request);
		
		PurchaseOrderHeader purchaseOrderHeader = new PurchaseOrderHeader();
		purchaseOrderHeader.setDatetime(LocalDateTime.now());
		purchaseOrderHeader.setDescription(request.getDescription());

		int totalPriceTransaction = 0;
		int totalCostTransaction = 0;
		List<PurchaseOrderDetail> listOrder = new ArrayList<>();
		for (PurchaseOderDetailModel order : request.getPurchaseOrderDetails()) {
			Items item = itemService.getItemByIdWithoutThrow(order.getItemId());

			if (item == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						Constants.statusCode.REFERENCE_NOT_FOUND.getDesc());
			}
			int totalPriceItem = item.getPrice() * order.getItemQty();
			int totalCostItem = item.getCost() * order.getItemQty();

			totalPriceTransaction += totalPriceItem;
			totalCostTransaction += totalCostItem;

			PurchaseOrderDetail orderDetail = new PurchaseOrderDetail();
			orderDetail.setItemId(order.getItemId());
			orderDetail.setItemQty(order.getItemQty());
			orderDetail.setItemCost(totalPriceItem);
			orderDetail.setItemPrice(totalCostItem);
			orderDetail.setPoh(purchaseOrderHeader);
			listOrder.add(orderDetail);
		}

		purchaseOrderHeader.setTotalCost(totalCostTransaction);
		purchaseOrderHeader.setTotalPrice(totalPriceTransaction);
		purchaseOrderHeader.setPods(listOrder);
		purchaseOrderHeaderRepository.save(purchaseOrderHeader);

		List<PurchaseOderDetailModel> listOrderResponse = new ArrayList<>();
		for (PurchaseOrderDetail order : purchaseOrderHeader.getPods()) {
			PurchaseOderDetailModel orderDetailModel = new PurchaseOderDetailModel();
			orderDetailModel.setId(order.getId());
			orderDetailModel.setItemId(order.getItemId());
			orderDetailModel.setItemCost(order.getItemCost());
			orderDetailModel.setItemPrice(order.getItemPrice());
			orderDetailModel.setItemQty(order.getItemQty());
			listOrderResponse.add(orderDetailModel);
		}
		return CreatePurchaseOrderResponse.builder().id(purchaseOrderHeader.getId())
				.description(purchaseOrderHeader.getDescription()).totalPrice(purchaseOrderHeader.getTotalPrice())
				.totalCost(purchaseOrderHeader.getTotalCost()).purchaseOrderDetails(listOrderResponse).build();
	}
}
