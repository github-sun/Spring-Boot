package org.sun.bootapp.ws;

import static org.mockito.Mockito.when;

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
public class UserWebServicesTest {
	
	private static final String baseAddress = "http://localhost:8080/bootapp/services";

	@Test
	public void getUsers() throws Exception {
		List<Object> providerList = new ArrayList<Object>();
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
		user.setName("1111111");
		user.setSex("1");
		user.setAge(20);
		user.setDate(new Date());
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		int result = WebClient.create(baseAddress, providerList).path("/user")
				.type(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).post(user, new GenericType<Integer>(){});
		System.out.println("===addUser result "+result);
	}
}
