package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Items;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemResponse;
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
		Items item = new Items();

		item.setName(request.getName());
		item.setDescription(request.getDescription());
		item.setPrice(request.getPrice());
		item.setCost(request.getCost());

		itemRepository.save(item);
		return CreateItemResponse.builder().name(item.getName()).description(item.getDescription())
				.price(item.getPrice()).cost(item.getCost()).build();
	}
}
