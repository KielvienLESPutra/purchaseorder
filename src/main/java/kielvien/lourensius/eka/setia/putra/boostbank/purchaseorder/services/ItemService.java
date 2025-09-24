package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import org.springframework.stereotype.Service;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.ItemRepository;

@Service
public class ItemService {
	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}
