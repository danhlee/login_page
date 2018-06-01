package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.User;
import com.capgemini.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
//	@Override
//	public Ride createRide(Ride ride) {
//		return rideRepository.createRide(ride);
//	}
	
	@Override
	public User getUser(Integer id) {
		return loginRepository.getUser(id);
		
	}
	
	@Override
	public List<User> getUsers() {
		return loginRepository.getUsers();
	}
	
	@Override
	public User loginUser(User login_user) {
		
		User db_user = loginRepository.findUser(login_user);
		
		// if user exists and password matches, return user row from DB
		if (db_user != null && login_user.getPassword().equals(db_user.getPassword())) {
			System.out.println("Login Successful!");
			
			return db_user;
		}
		else if (db_user != null && !login_user.getPassword().equals(db_user.getPassword())) {
			System.out.println("Password is incorrect!");
		}
		else {
			System.out.println("User does not exist!");
		}
		
		// if user doesn't exist or password incorrect, return null
		return null;
	}

}
