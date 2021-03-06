package com.capgemini.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
//	@RequestMapping(value = "/userLogin?login_username={login_username}&login_password={login_password}", method = RequestMethod.POST)
//	public @ResponseBody User loginUser(@PathVariable(value="login_username") String username, @PathVariable(value="login_password") String password) {
//		User login_user = new User();
//		login_user.setUsername(username);
//		login_user.setPassword(password);
//		
//		// returns null if not authenticated, otherwise returns row from user db
//		return loginService.loginUser(login_user);
//	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) {
		
		ModelMap model = new ModelMap();
		
		User login_user = new User();
		login_user.setUsername(request.getParameter("login_username"));
		login_user.setPassword(request.getParameter("login_password"));
		
		// returns null if not authenticated, otherwise returns row from user db
		User db_user = loginService.loginUser(login_user);
		if (db_user != null) {
			model.addAttribute("username", db_user.getUsername());
			model.addAttribute("password", db_user.getPassword());
			return new ModelAndView("welcome", model);
		}
		else {
			// TODO don't need this with exception handling
			return new ModelAndView("loginFail");
		}
	}
	
	@ExceptionHandler(RuntimeException.class) 
	public ModelAndView handle(RuntimeException ex) {
		ModelMap model = new ModelMap();
		model.addAttribute("msg", ex.getMessage());
		return new ModelAndView("loginFail", model);
	}
}
