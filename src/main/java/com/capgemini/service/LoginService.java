package com.capgemini.service;

import java.util.List;

import com.capgemini.model.User;



public interface LoginService {

	User getUser(Integer id);

	List<User> getUsers();

}