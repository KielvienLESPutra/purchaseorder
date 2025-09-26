package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item extends AuditTrail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 500)
	private String name;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "price")
	private int price;

	@Column(name = "cost")
	private int cost;
}
