package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "po_h")
public class PurchaseOrderHeader extends AuditTrail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "datetime")
	private LocalDateTime datetime;

	@Column(name = "desciption", length = 500)
	private String description;

	@Column(name = "total_price")
	private int totalPrice;

	@Column(name = "total_cost")
	private int totalCost;
	
	@OneToMany(mappedBy = "poh", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<PurchaseOrderDetail> pods;
}
