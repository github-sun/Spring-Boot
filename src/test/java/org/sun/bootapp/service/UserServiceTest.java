package org.sun.bootapp.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.sun.bootapp.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void getUserById() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userService.addUser(user);
		Assert.assertNotEquals(null, userService.getUserById(user.getId()));
	}

	@Test
	public void getUsers() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userService.addUser(user);
		Assert.assertNotEquals(null, userService.getUsers());
	}
	
	@Test
	public void addUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		Assert.assertEquals(1,userService.addUser(user));
	}
	
	@Test
	public void deleteUserById() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userService.addUser(user);
		Assert.assertEquals(1,userService.removeUserById(user.getId()));
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userService.addUser(user);
		
		String name = "222222";
		String sex = "0";
		user.setName(name);
		user.setSex(sex);
		Assert.assertEquals(1,userService.updateUser(user));
	}
}
