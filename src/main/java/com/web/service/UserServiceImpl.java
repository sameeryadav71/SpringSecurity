package com.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.domain.User;
import com.web.repository.UserRepository;

/**
 * 
 * @author s.yadav
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		Optional<User> userData = userRepository.findByUserName(user.getUserName());
		if (!userData.isPresent())
			return userRepository.save(user);
		else
			return null;
	}

	@Override
	public User updateUser(Integer id, User user) {
		Optional<User> entity = userRepository.findById(id);
		if (entity.isPresent()) {
			user.setId(id);
			return userRepository.save(user);
		} else
			return null;
	}

	public User createOrUpdateUser(User entity) {
		Optional<User> employee = userRepository.findById(entity.getId());

		if (employee.isPresent()) {
			User newEntity = employee.get();
			newEntity.setUserName(entity.getUserName());
			newEntity.setPassword(entity.getPassword());
			newEntity.setRoles(entity.getRoles());
			newEntity.setActive(entity.isActive());
			newEntity = userRepository.save(newEntity);
			return newEntity;
		} else {
			User userData = userRepository.findByUserNameAndPassword(entity.getUserName(), entity.getPassword());
			if (userData == null)
				return userRepository.save(entity);
			return null;
		}
	}

	@Override
	public void deleteUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			userRepository.deleteById(id);
	}

	@Override
	public User findUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		return null;

	}

	@Override
	public User findByUserName(String userName) {
		Optional<User> user = userRepository.findByUserName(userName);
		if (user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> userList = userRepository.findAll();
		if (userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<User>();
		}
	}

}
