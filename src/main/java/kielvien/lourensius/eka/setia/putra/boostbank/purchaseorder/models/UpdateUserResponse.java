package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateUserResponse {
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
}	
