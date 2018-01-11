package org.sun.bootapp.ws.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sun.bootapp.entity.User;
import org.sun.bootapp.service.UserService;
import org.sun.bootapp.ws.UserWebServices;

@Service
public class UserWebServicesImpl implements UserWebServices{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	

	@Override
	public User getUserById(int id) {
		logger.debug("===getUsers id "+id);
		return userService.getUserById(id);
	}
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<User> getUsers() {
		logger.debug("===getUsers");
		return userService.getUsers();
	}

	@Override
	public int addUser(User user) {
		logger.debug("===addUser　"+user.toString());
		userService.addUser(user);
		return user.getId();
	}

	@Override
	public int removeUser(int id) {
		logger.debug("===removeUser　id "+id);
		return userService.removeUserById(id);
	}

	@Override
	public int updateUser(User user) {
		logger.debug("===updateUser　user "+user.toString());
		user.setDate(new Date());
		return userService.updateUser(user);
	}
}
