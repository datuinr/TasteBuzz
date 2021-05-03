package com.tastebuzz.main.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.tastebuzz.main.models.User;
import com.tastebuzz.main.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//create - registers and hashs pw
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}

	//read - find all
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	//read - finds email
	public User findByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	//read - find user by id
	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	//update
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	//delete
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	//authenticate User
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findUserByEmail(email);
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password,  user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	// is is a duplicated email
	public boolean duplicateUser(String email) {
		User user = userRepository.findUserByEmail(email);
		if(user == null) {
			return false;
		} else {
			return true;
		}
	}
	
}
