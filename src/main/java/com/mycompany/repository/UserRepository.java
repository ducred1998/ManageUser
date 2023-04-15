package com.mycompany.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public Long countById(Integer id);
}
