package com.capgemini.repository;

import java.util.List;

import com.capgemini.model.User;

public interface LoginRepository {

	User getUser(Integer id);

	List<User> getUsers();

}