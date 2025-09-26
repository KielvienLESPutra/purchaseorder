package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
