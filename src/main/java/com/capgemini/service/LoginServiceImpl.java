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

}
