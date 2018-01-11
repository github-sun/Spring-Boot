package org.sun.bootapp.ws;

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
public class UserWebServicesTest {
	
	@Autowired
	private UserWebServices userWebServices;
	
	@Test
	public void getUserById() throws Exception {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		int id = userWebServices.addUser(user);
		Assert.assertEquals(true, id > 0);
		
		Assert.assertNotNull(userWebServices.getUserById(id));
	}
	
	@Test
	public void getUsers() throws Exception {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		int id = userWebServices.addUser(user);
		Assert.assertEquals(true, id > 0);
		
		Assert.assertEquals(true, userWebServices.getUsers().size() > 0);
	}
	
	@Test
	public void addUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		int id = userWebServices.addUser(user);
		Assert.assertEquals(true, id > 0);
	}
	
	@Test
	public void removeUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		int id = userWebServices.addUser(user);
		Assert.assertEquals(true, id > 0);
		
		Assert.assertEquals(true, userWebServices.removeUser(id) == 1);
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		int id = userWebServices.addUser(user);
		Assert.assertEquals(true, id > 0);
		
		user = new User();
		user.setId(id);
		user.setName("2222222");
		user.setSex("0");
		user.setAge(21);
		
		Assert.assertEquals(true, userWebServices.updateUser(user) == 1);
	}
}
