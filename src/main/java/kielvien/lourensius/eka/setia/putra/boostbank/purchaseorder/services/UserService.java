package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public GetUserResponse findUser(int userId) {
		User user = getUserById(userId);

		return GetUserResponse.builder().id(user.getId()).firstName(user.getFirstName()).lastName(user.getLastName())
				.phone(user.getPhone()).email(user.getEmail()).build();
	}

	@Transactional
	public UpdateUserResponse updateUser(int userId, UpdateUserRequest request) {
		validationService.validate(request);
		User user = getUserById(userId);

		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPhone(request.getPhone());
		user.setEmail(request.getEmail());
		userRepository.save(user);

		return UpdateUserResponse.builder().firstName(user.getFirstName()).lastName(user.getLastName())
				.phone(user.getPhone()).email(user.getEmail()).build();
	}

	private User getUserById(int userId) {
		return userRepository.findById(userId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.statusCode.NOT_FOUND.getDesc()));
	}

	@Transactional
	public int deleteUser(int userId) {
		User user = getUserById(userId);

		userRepository.delete(user);
		return user.getId();
	}

	public Page<GetUserResponse> findAllUser(int page, int totalSize) {
		Pageable pageable = PageRequest.of(page, totalSize);
		Page<User> pageUser = userRepository.findAll(pageable);

		List<GetUserResponse> listUser = pageUser.getContent().stream()
				.map(user -> GetUserResponse.builder().firstName(user.getFirstName()).lastName(user.getLastName())
						.email(user.getEmail()).phone(user.getPhone()).build())
				.toList();
		return new PageImpl<>(listUser, pageable, pageUser.getTotalElements());
	}
}
