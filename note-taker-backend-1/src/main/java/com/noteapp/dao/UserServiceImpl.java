package com.noteapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noteapp.model.UserModel;
import com.noteapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModel findById(Long userId) {
		 if (userId == null) {
		        throw new IllegalArgumentException("User ID must not be null");
		    }
		  return userRepository.findById(userId).orElse(null);
	}

	@Override
	public UserModel saveUser(UserModel userModel) {
		UserModel userSaved = userRepository.save(userModel);
		return userSaved;
	}

}