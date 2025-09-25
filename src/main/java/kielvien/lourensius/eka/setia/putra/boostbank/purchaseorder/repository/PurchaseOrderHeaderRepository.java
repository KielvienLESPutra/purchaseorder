package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderHeader;

@Repository
public interface PurchaseOrderHeaderRepository extends JpaRepository<PurchaseOrderHeader, Integer>{

}
