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
	
}
