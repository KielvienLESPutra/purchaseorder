package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Item;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.User;

public class ConstantsDataTest {
	public static final String EXCEED_CHARACTER = "5kl8jGM1gFhnDL0lTIDuAUusA0ZwMYJlkd317GeDs5JIrClVD2JzDG7vo7s1pOwFosHP7GtBjqdm4JJCHHiBfnY2cXZdWT2yhfet1"
			+ "jElE9WdQ763cW9kdgzv2SVmIKPxzNqgg4pga92KV0ivP7JlRSoB0vfg09dLgV9H15RR5RS3G6yD6GsHUJCakBHPVW89sJwxDxLC33ZoQzSV4HwnsARu1T0WIgyGgUPh"
			+ "iAt0dc3s69ycmSy9EOljHtlYcX0EJzIgmKDwtXd1t88tH3exlTNNhpnXVKmPGFdESNxFaNfZJlhIgjLuHrmQimaND9tQA2iFOCbexTItIfltoVC4uow2WctF67uKAxw"
			+ "ABIWZbMYZCd1EuuXIrOJ6LmXhvxno3BT3MLBZ3UFVyV1b0Zu3zpkOXFEvgdkigZhnXgXIfT68BHTtY1FIzVwBcEuMPL6VVCKvezv6PXH5YaWktsR8Tkc5dpg2048yq9"
			+ "IoFmfU9mQ2na0dAf6SXgXIfT68t88tH3exlTNN";

	public static final class usersMokito {

		public static User singleUser() {
			User user = new User();
			user.setId(1);
			user.setFirstName("first name");
			user.setLastName("last name");
			user.setEmail("myEmail@gmail.com");
			user.setPhone("085888888888");
			user.setCreatedBy(Constants.USER_SYSTEM);
			user.setCreatedDatetime(LocalDateTime.now());
			user.setUpdatedBy(Constants.USER_SYSTEM);
			user.setUpdatedDatetime(LocalDateTime.now());

			return user;
		}

		public static List<User> allUser() {
			List<User> listUser = new ArrayList<User>();

			for (int i = 0; i <= 20; i++) {
				User user = new User();
				user.setId(i);
				user.setFirstName("first name " + 1);
				user.setLastName("last name " + 1);
				user.setEmail("myEmail" + i + "@gmail.com");
				if (i < 10) {
					user.setPhone("08588888888" + i);
				} else {
					user.setPhone("0858888888" + i);
				}
				user.setCreatedBy(Constants.USER_SYSTEM);
				user.setCreatedDatetime(LocalDateTime.now());
				user.setUpdatedBy(Constants.USER_SYSTEM);
				user.setUpdatedDatetime(LocalDateTime.now());
				
				listUser.add(user);
			}

			return listUser;
		}
	}

	public static final class ItemsMokito {

		public static Item singleItem() {
			Item item = new Item();
			item.setId(1);
			item.setName("barang abc");
			item.setDescription("Barang dummy abc");
			item.setPrice(1000);
			item.setCost(500);
			item.setCreatedBy(Constants.USER_SYSTEM);
			item.setCreatedDatetime(LocalDateTime.now());
			item.setUpdatedBy(Constants.USER_SYSTEM);
			item.setUpdatedDatetime(LocalDateTime.now());
			return item;
		}

		public static List<Item> listItem() {
			List<Item> listItem = new ArrayList<Item>();
			
			for (int i = 0; i <= 20; i++) {
				Item item = new Item();
				item.setId(i);
				item.setName("barang " + i);
				item.setDescription("Barang desc dummy " + 1);
				item.setPrice(1000);
				item.setCost(200);
				item.setCreatedBy(Constants.USER_SYSTEM);
				item.setCreatedDatetime(LocalDateTime.now());
				item.setUpdatedBy(Constants.USER_SYSTEM);
				item.setUpdatedDatetime(LocalDateTime.now());
				
				listItem.add(item);
			}
			return listItem;
		}
	}
}
