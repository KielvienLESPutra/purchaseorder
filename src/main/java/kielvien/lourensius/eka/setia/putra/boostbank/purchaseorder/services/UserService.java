package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.User;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	private ValidationService validationService;

	public UserService(UserRepository userRepository, ValidationService validationService) {
		this.userRepository = userRepository;
		this.validationService = validationService;
	}

	@Transactional
	public CreateUserResponse createUser(CreateUserRequest request) {
		validationService.validate(request);

		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		userRepository.save(user);

		return CreateUserResponse.builder().id(user.getId()).firstName(user.getFirstName()).lastName(user.getLastName())
				.email(user.getEmail()).phone(user.getPhone()).build();
	}

	public GetUserResponse getUser(int id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.statusCode.NOT_FOUND.getDesc()));

		return GetUserResponse.builder().firstName(user.getFirstName()).lastName(user.getLastName())
				.phone(user.getPhone()).email(user.getEmail()).build();
	}

	@Transactional
	public UpdateUserResponse updateUser(int userid, UpdateUserRequest request) {
		validationService.validate(request);
		
		User user = userRepository.findById(userid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.statusCode.NOT_FOUND.getDesc()));

		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPhone(request.getPhone());
		user.setEmail(request.getEmail());
		userRepository.save(user);

		return UpdateUserResponse.builder().firstName(user.getFirstName()).lastName(user.getLastName())
				.phone(user.getPhone()).email(user.getEmail()).build();
	}
}
