package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.User;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserResponse;
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
}
