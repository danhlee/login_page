package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.model.User;
import com.capgemini.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
//	@RequestMapping(value = "/ride", method = RequestMethod.POST) 
//	public @ResponseBody Ride createRide(@RequestBody Ride ride) {
//		return loginService.createRide(ride);
//	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable(value="id") Integer id) {
		return loginService.getUser(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		return loginService.getUsers();
	}
	
	@RequestMapping(value = "/userLogin?login_username={login_username}&login_password={login_password}", method = RequestMethod.POST)
	public @ResponseBody User loginUser(@PathVariable(value="login_username") String username, @PathVariable(value="login_password") String password) {
		User login_user = new User();
		login_user.setUsername(username);
		login_user.setPassword(password);
		
		// returns null if not authenticated, otherwise returns row from user db
		return loginService.loginUser(login_user);
	}
}
