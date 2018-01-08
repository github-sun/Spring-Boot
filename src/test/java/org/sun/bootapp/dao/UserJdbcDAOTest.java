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
public class UserJdbcDAOTest {
	
	@Autowired
	private UserJdbcDAO userJdbcDAO;
	

	@Test
	public void queryUsers() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		userJdbcDAO.insertUser(user);
		Assert.assertNotEquals(null, userJdbcDAO.queryUsers());
	}
}
