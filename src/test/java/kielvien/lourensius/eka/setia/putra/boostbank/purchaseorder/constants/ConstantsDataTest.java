package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Item;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderDetail;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderHeader;
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

			for (int i = 0; i <= 9; i++) {
				User user = new User();
				user.setId(i);
				user.setFirstName("first name " + i);
				user.setLastName("last name " + i);
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

		public static Item singleItem(int id) {
			Item item = new Item();
			item.setId(id);
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

			for (int i = 0; i <= 9; i++) {
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

	public static final class PurchaseOrderMockito {

		public static PurchaseOrderHeader singleTransaction() {
			PurchaseOrderHeader transaction = new PurchaseOrderHeader();
			transaction.setId(1);
			transaction.setDescription("Transaksi dummy 1");
			transaction.setTotalCost(15000);
			transaction.setTotalPrice(7500);
			transaction.setCreatedBy(Constants.USER_SYSTEM);
			transaction.setCreatedDatetime(LocalDateTime.now());
			transaction.setUpdatedBy(Constants.USER_SYSTEM);
			transaction.setUpdatedDatetime(LocalDateTime.now());

			List<PurchaseOrderDetail> listOrderDetail = new ArrayList<PurchaseOrderDetail>();
			for (int i = 1; i <= 5; i++) {
				PurchaseOrderDetail orderDetail = new PurchaseOrderDetail();
				orderDetail.setId(i);
				orderDetail.setItemId(i);
				orderDetail.setItemPrice(1000);
				orderDetail.setItemCost(500);
				orderDetail.setItemQty(i);
				orderDetail.setCreatedBy(Constants.USER_SYSTEM);
				orderDetail.setCreatedDatetime(LocalDateTime.now());
				orderDetail.setUpdatedBy(Constants.USER_SYSTEM);
				orderDetail.setUpdatedDatetime(LocalDateTime.now());
				orderDetail.setPoh(transaction);

				listOrderDetail.add(orderDetail);
			}
			transaction.setPods(listOrderDetail);

			return transaction;
		}

		public static List<PurchaseOrderHeader> listTransaction() {
			List<PurchaseOrderHeader> listTransaction = new ArrayList<PurchaseOrderHeader>();
			int counter = 1;

			for (int i = 0; i <= 9; i++) {
				PurchaseOrderHeader transaction = new PurchaseOrderHeader();
				transaction.setId(i);
				transaction.setDescription("Transaksi dummy " + i);
				transaction.setTotalCost(15000);
				transaction.setTotalPrice(7500);
				transaction.setCreatedBy(Constants.USER_SYSTEM);
				transaction.setCreatedDatetime(LocalDateTime.now());
				transaction.setUpdatedBy(Constants.USER_SYSTEM);
				transaction.setUpdatedDatetime(LocalDateTime.now());

				List<PurchaseOrderDetail> listOrderDetail = new ArrayList<PurchaseOrderDetail>();
				for (int y = 1; y <= 5; y++) {
					PurchaseOrderDetail orderDetail = new PurchaseOrderDetail();
					orderDetail.setId(counter);
					orderDetail.setItemId(y);
					orderDetail.setItemPrice(1000);
					orderDetail.setItemCost(500);
					orderDetail.setItemQty(y);
					orderDetail.setCreatedBy(Constants.USER_SYSTEM);
					orderDetail.setCreatedDatetime(LocalDateTime.now());
					orderDetail.setUpdatedBy(Constants.USER_SYSTEM);
					orderDetail.setUpdatedDatetime(LocalDateTime.now());
					orderDetail.setPoh(transaction);

					listOrderDetail.add(orderDetail);
					counter++;
				}
				transaction.setPods(listOrderDetail);
				listTransaction.add(transaction);
			}

			return listTransaction;
		}
	}
}
