package com.hiddenfounders.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hiddenfounders.models.User;

public interface UserDao extends CrudRepository<User, Long>{
	
	User findByEmail(String email);
}
