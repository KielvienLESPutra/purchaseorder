package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
		CreateUserResponse response = userService.createUser(request);

		return WebResponse.<CreateUserResponse>builder().data(response).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}

	@GetMapping(path = "/finduser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<GetUserResponse> getUser(@PathVariable int userId) {
		GetUserResponse response = userService.findUser(userId);

		return WebResponse.<GetUserResponse>builder().data(response).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}

	@PutMapping(path = "/update/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<UpdateUserResponse> updateUser(@PathVariable int userId,
			@RequestBody UpdateUserRequest request) {
		UpdateUserResponse response = userService.updateUser(userId, request);

		return WebResponse.<UpdateUserResponse>builder().data(response).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}

	@DeleteMapping(path = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public WebResponse<Integer> deleteuser(@PathVariable int userId) {
		Integer userIdDeleted = userService.deleteUser(userId);

		return WebResponse.<Integer>builder().data(userIdDeleted).statusCode(Constants.statusCode.OK.getCode())
				.desc(Constants.statusCode.OK.getDesc()).build();
	}
}
