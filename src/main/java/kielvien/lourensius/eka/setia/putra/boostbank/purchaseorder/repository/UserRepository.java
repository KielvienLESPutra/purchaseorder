package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
