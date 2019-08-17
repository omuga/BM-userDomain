package com.tps.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;


import com.tps.user.controller.UserController;
import com.tps.user.models.User;
import com.tps.user.repository.UserRepository;

import org.junit.Before;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
public class DemoApplicationTests {
	protected MockMvc mockMvc;

	@Mock
	UserRepository userRepository;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
		throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Before
	public void setUp(){

		final UserController userController = new UserController(userRepository);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void userControllerPostTest() throws Exception{
		String uri = "/users";
		User user = new User();
		user.setUsername("test");
		user.setPassword("testpw");
		user.setEmail("test@test.cl");
		String inputJson = mapToJson(user);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
	  .contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
	  int status = mvcResult.getResponse().getStatus();
	  assertEquals(200, status);
	}

	@Test
	public void userControllerGetTest() throws Exception {
		String uri = "/users";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
		.accept(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void userControllerDeleteTest() throws Exception {
		String uri = "/users/1";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)
		.accept(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	@Test
	public void contextLoads() {
	}

}
