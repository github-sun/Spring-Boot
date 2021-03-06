package org.sun.bootapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sun.bootapp.annotation.Log;
import org.sun.bootapp.dao.UserDAO;
import org.sun.bootapp.dao.UserJdbcDAO;
import org.sun.bootapp.entity.User;
import org.sun.bootapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserJdbcDAO userJdbcDAO;

	@Override
	public User getUserById(int id) {
		User user = userDAO.queryUserById(id);
		logger.debug("===getUsers "+user);
		return user;
	}
	
	@Override
	public List<User> getUsers() {
		logger.info("===UserServiceImpl getUsers ");
		//return userDAO.queryUsers();
		return userJdbcDAO.queryUsers();
	}

	@Override
	public int addUser(User user) {
		int result = userDAO.insertUser(user);
		logger.debug("===addUser "+result + " user "+user.toString());
		return user.getId();
	}

	@Override
	public int removeUserById(int id) {
		return userDAO.deleteUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
}
