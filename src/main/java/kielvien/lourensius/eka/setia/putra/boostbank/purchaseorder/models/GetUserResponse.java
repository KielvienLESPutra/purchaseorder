package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GetUserResponse {
	private Integer id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
}
