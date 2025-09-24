package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "po_d")
public class PurchaseOrderDetail extends AuditTrail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poh_id")
	private PurchaseOrderHeader poh;
	
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_qty")
	private int itemQty;

	@Column(name = "item_cost")
	private int itemCost;

	@Column(name = "item_price")
	private int itemPrice;
}
