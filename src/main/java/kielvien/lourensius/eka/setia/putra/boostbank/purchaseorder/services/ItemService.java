package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Item;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateItemRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.ItemRepository;

@Service
public class ItemService {
	private ItemRepository itemRepository;
	private ValidationService validationService;

	public ItemService(ItemRepository itemRepository, ValidationService validationService) {
		this.itemRepository = itemRepository;
		this.validationService = validationService;
	}

	@Transactional
	public CreateItemResponse createItem(CreateItemRequest request) {
		validationService.validate(request);
		Item item = new Item();

		item.setName(request.getName());
		item.setDescription(request.getDescription());
		item.setPrice(request.getPrice());
		item.setCost(request.getCost());
		itemRepository.save(item);

		return CreateItemResponse.builder().id(item.getId()).name(item.getName()).description(item.getDescription())
				.price(item.getPrice()).cost(item.getCost()).build();
	}

	public Item getItemByIdWithoutThrow(int itemId) {
		return itemRepository.findById(itemId).orElse(null);
	}

	public Item getItemById(int itemId) {
		return itemRepository.findById(itemId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.statusCode.NOT_FOUND.getDesc()));
	}

	public GetItemResponse findItem(int itemId) {
		Item item = getItemById(itemId);

		return GetItemResponse.builder().id(item.getId()).name(item.getName()).description(item.getDescription())
				.price(item.getPrice()).cost(item.getCost()).build();
	}

	@Transactional
	public UpdateItemResponse updateItem(int itemId, UpdateItemRequest request) {
		validationService.validate(request);
		Item item = getItemById(itemId);

		item.setName(request.getName());
		item.setDescription(request.getDescription());
		item.setPrice(request.getPrice());
		item.setCost(request.getCost());
		itemRepository.save(item);

		return UpdateItemResponse.builder().name(item.getName()).description(item.getDescription())
				.price(item.getPrice()).cost(item.getCost()).build();
	}

	@Transactional
	public int deleteItem(int itemId) {
		Item item = getItemById(itemId);

		itemRepository.delete(item);
		return item.getId();
	}

	public Page<GetItemResponse> findAllItem(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Item> pageItem = itemRepository.findAll(pageable);

		List<GetItemResponse> listItem = pageItem.getContent().stream()
				.map(item -> GetItemResponse.builder().id(item.getId()).name(item.getName())
						.description(item.getDescription()).cost(item.getCost()).price(item.getPrice()).build())
				.toList();

		return new PageImpl<>(listItem, pageable, pageItem.getTotalElements());
	}
}
