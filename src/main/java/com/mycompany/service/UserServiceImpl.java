package com.mycompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.entity.User;
import com.mycompany.exception.UserNotFoundException;
import com.mycompany.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserById(Integer id) throws UserNotFoundException{
		
		Optional<User> result = userRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("Could not find any users with ID: " + id);
	}

	@Override
	public void delete(Integer id) throws UserNotFoundException{
		
		Long count = userRepository.countById(id);
		if(count == null || count == 0) {
			throw new UserNotFoundException("Could not find any users with ID: " + id);
		}
		userRepository.deleteById(id);
	}

}
