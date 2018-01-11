package org.sun.bootapp;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AppTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getUserByIdTest() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "testtesttest");
		map.put("sex", "1");
		map.put("age", "40");
		
		MvcResult result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())   
                .andReturn();
		String idString = result.getResponse().getContentAsString();
		int id = Integer.valueOf(idString);
		System.out.println("===getUserByIdTest "+id); 
		Assert.assertEquals(true, id > 0);
		
		result = mockMvc.perform(get("/user/"+id))
				.andExpect(status().isOk())   
                .andReturn();
		String resultString = result.getResponse().getContentAsString();
		System.out.println("===getUserByIdTest "+resultString);
		Assert.assertEquals(true, resultString.length() > 0);
	}
	
	@Test
	public void getUsers() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "testtesttest");
		map.put("sex", "1");
		map.put("age", "40");
		
		MvcResult result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())   
                .andReturn();
		String idString = result.getResponse().getContentAsString();
		int id = Integer.valueOf(idString);
		System.out.println("===getUsers "+id); 
		Assert.assertEquals(true, id > 0);
		
		result = mockMvc.perform(get("/user"))
				.andExpect(status().isOk())   
                .andReturn();
		String resultString = result.getResponse().getContentAsString();
		System.out.println("===getUsers "+resultString); 
		Assert.assertEquals(true, resultString.length() > 0);
	}
	
	@Test
	public void addUser() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "testtesttest");
		map.put("sex", "1");
		map.put("age", "40");
		
		MvcResult result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())   
                .andReturn();
		String idString = result.getResponse().getContentAsString();
		int id = Integer.valueOf(idString);
		System.out.println("===addUser "+id); 
		Assert.assertEquals(true, id > 0);
	}
	
	@Test
	public void removeUser() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "testtesttest");
		map.put("sex", "1");
		map.put("age", "40");
		
		MvcResult result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())   
                .andReturn();
		
		String idString = result.getResponse().getContentAsString();
		int id = Integer.valueOf(idString);
		System.out.println("===addUser "+id); 
		Assert.assertEquals(true, id > 0);
		
		result = mockMvc.perform(delete("/user/"+id))
				.andExpect(status().isOk())   
                .andReturn();
		String resultString = result.getResponse().getContentAsString();
		System.out.println("===removeUser "+resultString); 
		Assert.assertEquals(true, Integer.valueOf(resultString) == 1);
	}
	
	@Test
	public void updateUser() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "testtesttest");
		map.put("sex", "1");
		map.put("age", "40");
		
		MvcResult result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())   
                .andReturn();
		
		String idString = result.getResponse().getContentAsString();
		int id = Integer.valueOf(idString);
		System.out.println("===updateUser "+id); 
		Assert.assertEquals(true, id > 0);
		
		map = new HashMap<>();
		map.put("id", id);
		map.put("name", "testtesttest22222");
		map.put("sex", "0");
		map.put("age", "41");
		
		result = mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())   
                .andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		System.out.println("===updateUser "+resultString); 
		Assert.assertEquals(true, Integer.valueOf(resultString) == 1);
	}
}
