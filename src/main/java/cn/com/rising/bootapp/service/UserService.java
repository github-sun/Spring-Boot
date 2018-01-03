package cn.com.rising.bootapp.service;

import java.util.List;

import cn.com.rising.bootapp.entity.User;

public interface UserService {

	User getUserById(int id);
	
	List<User> getUsers();
	
	int addUser(User user);
	
	int deleteUserById(int id);
	
	int updateUser(User user);
}
