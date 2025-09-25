package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetPurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.PurchaseOderDetailModel;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdatePurchaseOrderResponse;
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

		List<PurchaseOderDetailModel> listOrderModel = wrapPurchaseOrderModel(true, purchaseOrderHeader.getPods());
		return CreatePurchaseOrderResponse.builder().id(purchaseOrderHeader.getId())
				.description(purchaseOrderHeader.getDescription()).totalPrice(purchaseOrderHeader.getTotalPrice())
				.totalCost(purchaseOrderHeader.getTotalCost()).purchaseOrderDetails(listOrderModel).build();
	}

	public PurchaseOrderHeader getPurchaseOrderById(int purchaseOrderId) {
		return purchaseOrderHeaderRepository.findById(purchaseOrderId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.statusCode.NOT_FOUND.getDesc()));
	}

	public GetPurchaseOrderResponse findPurchaseOrder(int purchaseOrderId) {
		PurchaseOrderHeader purchaseOrderHeader = getPurchaseOrderById(purchaseOrderId);
		List<PurchaseOderDetailModel> listOrderModel = wrapPurchaseOrderModel(false, purchaseOrderHeader.getPods());

		return GetPurchaseOrderResponse.builder().description(purchaseOrderHeader.getDescription())
				.totalCost(purchaseOrderHeader.getTotalCost()).totalPrice(purchaseOrderHeader.getTotalPrice())
				.purchaseOrderDetails(listOrderModel).build();
	}

	@Transactional
	public UpdatePurchaseOrderResponse updatePruchaseOrder(int purchaseOrderId, UpdatePurchaseOrderRequest request) {
		validationService.validate(request);

		PurchaseOrderHeader purchaseOrderHeader = getPurchaseOrderById(purchaseOrderId);
		Map<Integer, PurchaseOrderDetail> mapDataOrder = new HashMap<>();

		if (request.getPurchaseOrderDetails().size() > purchaseOrderHeader.getPods().size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.statusCode.BAD_REQUEST.getDesc());
		}

		for (PurchaseOrderDetail orderDetail : purchaseOrderHeader.getPods()) {
			mapDataOrder.put(orderDetail.getId(), orderDetail);
		}

		int totalCostTransaction = 0;
		int totalPriceTransaction = 0;
		for (PurchaseOderDetailModel orderModel : request.getPurchaseOrderDetails()) {
			if (orderModel.getId() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						Constants.statusCode.REFERENCE_NULL.getDesc());
			}

			if (!mapDataOrder.containsKey(orderModel.getId())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						Constants.statusCode.REFERENCE_NOT_FOUND.getDesc());
			}

			PurchaseOrderDetail orderDetail = mapDataOrder.get(orderModel.getId());
			orderDetail.setItemId(purchaseOrderId);
			orderDetail.setItemQty(purchaseOrderId);

			Items item = itemService.getItemById(orderModel.getItemId());

			int totalCostItem = item.getCost() * orderModel.getItemQty();
			int totalPriceItem = item.getPrice() * orderModel.getItemQty();
			totalCostTransaction += totalCostItem;
			totalPriceTransaction += totalPriceItem;
			orderDetail.setItemCost(totalCostItem);
			orderDetail.setItemPrice(totalPriceItem);
		}

		purchaseOrderHeader.setDescription(request.getDescription());
		purchaseOrderHeader.setTotalCost(totalCostTransaction);
		purchaseOrderHeader.setTotalPrice(totalPriceTransaction);
		purchaseOrderHeaderRepository.save(purchaseOrderHeader);

		List<PurchaseOderDetailModel> listOrderModel = wrapPurchaseOrderModel(false, purchaseOrderHeader.getPods());
		return UpdatePurchaseOrderResponse.builder().description(purchaseOrderHeader.getDescription())
				.totalCost(purchaseOrderHeader.getTotalCost()).totalPrice(purchaseOrderHeader.getTotalPrice())
				.purchaseOrderDetails(listOrderModel).build();
	}

	private List<PurchaseOderDetailModel> wrapPurchaseOrderModel(boolean wrapId,
			List<PurchaseOrderDetail> listOrderDetail) {
		List<PurchaseOderDetailModel> listOrderModel = new ArrayList<>();
		for (PurchaseOrderDetail orderDetail : listOrderDetail) {
			PurchaseOderDetailModel orderModel = new PurchaseOderDetailModel();

			if (wrapId) {
				orderModel.setId(orderDetail.getId());
			}
			orderModel.setItemId(orderDetail.getItemId());
			orderModel.setItemPrice(orderDetail.getItemPrice());
			orderModel.setItemCost(orderDetail.getItemCost());
			orderModel.setItemQty(orderDetail.getItemQty());

			listOrderModel.add(orderModel);
		}

		return listOrderModel;
	}
}
