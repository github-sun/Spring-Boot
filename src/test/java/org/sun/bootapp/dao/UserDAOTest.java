package org.sun.bootapp.dao;

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
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void queryUserById() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userDAO.insertUser(user);
		Assert.assertNotEquals(null, userDAO.queryUserById(user.getId()));
	}

	@Test
	public void queryUsers() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userDAO.insertUser(user);
		Assert.assertNotEquals(null, userDAO.queryUsers());
	}

	@Test
	public void insertUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		Assert.assertEquals(1, userDAO.insertUser(user));
	}
	
	@Test
	public void deleteUserById() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userDAO.insertUser(user);
		Assert.assertEquals(1, userDAO.deleteUserById(user.getId()));
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userDAO.insertUser(user);
		
		String name = "222222";
		String sex = "0";
		user.setName(name);
		user.setSex(sex);
		
		Assert.assertEquals(1, userDAO.updateUser(user));
	}
}
