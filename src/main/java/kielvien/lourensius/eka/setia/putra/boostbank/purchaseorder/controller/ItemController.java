package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateItemRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services.ItemService;

@RestController
@RequestMapping(path = "/api/item")
public class ItemController {

	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<CreateItemResponse> createItem(@RequestBody CreateItemRequest request) {
		CreateItemResponse response = itemService.createItem(request);

		return WebResponse.<CreateItemResponse>builder().data(response).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}

	@GetMapping(path = "/finditem/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<GetItemResponse> getItem(@PathVariable int itemId) {
		GetItemResponse response = itemService.findItem(itemId);

		return WebResponse.<GetItemResponse>builder().data(response).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}

	@PutMapping(path = "/update/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<UpdateItemResponse> updateItem(@PathVariable int itemId,
			@RequestBody UpdateItemRequest request) {
		UpdateItemResponse response = itemService.updateItem(itemId, request);

		return WebResponse.<UpdateItemResponse>builder().data(response).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}

	@DeleteMapping(path = "/delete/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<Integer> deleteItem(@PathVariable int itemId) {
		Integer itemIdDeleted = itemService.deleteItem(itemId);

		return WebResponse.<Integer>builder().data(itemIdDeleted).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}
}
