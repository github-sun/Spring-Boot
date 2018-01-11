package org.sun.bootapp.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.sun.bootapp.entity.User;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserWebServicesClient {
	
	private static final String baseAddress = "http://localhost:8080/bootapp/services";

	@Test
	public void getUserById() throws Exception {
		User user = new User();
		user.setName("getUserById");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		int id = WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).post(user, new GenericType<Integer>(){});
		
		providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		Object result = WebClient.create(baseAddress, providerList).path("/user/"+id)
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<Object>(){});

		System.out.println("===getUserById "+result.toString());
	}
	
	@Test
	public void getUsers() throws Exception {
		User user = new User();
		user.setName("getUsers");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).post(user, new GenericType<Integer>(){});
		
		providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		List<Object> resultList = WebClient.create(baseAddress, providerList).path("/user")
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});

		for (Object result : resultList) {
			System.out.println("===getUsers "+result);
		}
	}
	
	@Test
	public void addUser() {
		User user = new User();
		user.setName("addUser");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		int id = WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).post(user, new GenericType<Integer>(){});
		System.out.println("===addUser id "+id);
	}
	
	@Test
	public void removeUser() {
		User user = new User();
		user.setName("removeUser");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		int id = WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).post(user, new GenericType<Integer>(){});
		System.out.println("===removeUser id "+id);
		WebClient.create(baseAddress, providerList).path("/user/"+id)
				.type(MediaType.TEXT_PLAIN)
		.accept(MediaType.APPLICATION_JSON).delete();
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setName("updateUser");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		int id = WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).post(user, new GenericType<Integer>(){});
		System.out.println("===updateUser id "+id);
		
		user = new User();
		user.setId(id);
		user.setName("updateUser2222");
		user.setSex("0");
		user.setAge(21);
		int result = WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).put(user, new GenericType<Integer>(){});
		System.out.println("===updateUser result "+result);
	}
}
