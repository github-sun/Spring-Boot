package org.sun.bootapp.service;

import java.util.List;

import org.sun.bootapp.entity.User;

public interface UserService {

	User getUserById(int id);
	
	List<User> getUsers();
	
	int addUser(User user);
	
	int removeUserById(int id);
	
	int updateUser(User user);
}
