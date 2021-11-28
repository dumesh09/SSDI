package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.User;
import ssdi.group7.organdonationsystem.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return user;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long userId, User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		user.setActiveUser(userDetails.getActiveUser());
		user.setAddress(userDetails.getAddress());
		user.setAge(userDetails.getAge());
		user.setBloodType(userDetails.getBloodType());
		user.setPhone(userDetails.getPhone());
		user.setUserType(userDetails.getUserType());
		final User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	public Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setActiveUser("N");
		updateUser(userId, user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
