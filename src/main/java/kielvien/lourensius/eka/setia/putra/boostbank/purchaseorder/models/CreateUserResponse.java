package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
}
