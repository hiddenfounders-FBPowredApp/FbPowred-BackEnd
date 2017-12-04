package com.hiddenfounders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hiddenfounders.config.ApiUrls;
import com.hiddenfounders.models.User;
import com.hiddenfounders.models.dao.UserDao;


@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	@CrossOrigin
	@RequestMapping(value= ApiUrls.NEW_ACCOUNT, method=RequestMethod.POST)
	public boolean createAccount(@RequestBody User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userDao.save(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
