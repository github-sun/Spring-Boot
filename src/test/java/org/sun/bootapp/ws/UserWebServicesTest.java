package org.sun.bootapp.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class UserWebServicesTest {

	@LocalServerPort
	private int port;

	@Test
	public void getUsers() throws Exception {
		String baseAddress = "http://localhost:8080/bootapp/services";

		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		List<Object> productList = WebClient.create(baseAddress, providerList).path("/user")
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});

		for (Object product : productList) {
			System.out.println(product);
		}
	}
}
