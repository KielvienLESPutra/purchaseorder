package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditTrail {
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "created_datetime")
	private LocalDateTime createdDatetime;

	@Column(name = "updated_datetime")
	private LocalDateTime  updatedDatetime;
}
