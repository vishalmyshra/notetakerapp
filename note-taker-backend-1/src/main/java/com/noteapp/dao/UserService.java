package com.noteapp.dao;

import com.noteapp.model.UserModel;

public interface UserService {
	UserModel findById(Long userId);
	UserModel saveUser(UserModel userModel);
}
