package com.mycompany.service;

import java.util.List;

import com.mycompany.entity.User;
import com.mycompany.exception.UserNotFoundException;

public interface UserService {
	
	List<User> listAll();
	void save(User user);
	User findUserById(Integer id) throws UserNotFoundException;
	void delete(Integer id) throws UserNotFoundException;
}
