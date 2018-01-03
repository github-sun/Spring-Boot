package cn.com.rising.bootapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.rising.bootapp.dao.UserDAO;
import cn.com.rising.bootapp.entity.User;
import cn.com.rising.bootapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUserById(int id) {
		return userDAO.queryUserById(id);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.queryUsers();
	}

	@Override
	public int addUser(User user) {
		return userDAO.insertUser(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userDAO.deleteUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
}
