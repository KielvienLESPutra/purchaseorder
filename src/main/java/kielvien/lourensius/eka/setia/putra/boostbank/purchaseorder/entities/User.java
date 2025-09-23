package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AuditTrail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name", length = 500)
	private String firstName;

	@Column(name = "last_name", length = 500)
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;
}
