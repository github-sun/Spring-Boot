package org.sun.bootapp.ws.impl;

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
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<User> getUsers() {
		logger.debug("===getUsers");
		return userService.getUsers();
	}

}
