package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import com.capgemini.entities.UserDetails;

import com.capgemini.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserDetailsController.class)
class UserDetailsControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserDetailsServiceImpl userdetailsservice;

	@Test
	void findUserDetailstest() throws Exception {
		UserDetails ud = new UserDetails();
		ud.setUserName("Aneesh");
		ud.setUserEmail("aneesh054@gmail.com");

		Mockito.when(userdetailsservice.findUserDetailsById(Mockito.anyInt())).thenReturn(ud);
		mockMvc.perform(get("/api/user/1")).andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Aneesh"));
	}

	@Test
	void createUserDetailsTest() throws Exception {
		UserDetails ud = new UserDetails();
		ud.setUserName("Aneesh");
		ud.setUserEmail("aneesh054@gmail.com");

		Mockito.when(userdetailsservice.createUserDetails(Mockito.any())).thenReturn(ud);
		mockMvc.perform(post("/api/user/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(ud)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_email").value("aneesh054@gmail.com"));
	}

}
