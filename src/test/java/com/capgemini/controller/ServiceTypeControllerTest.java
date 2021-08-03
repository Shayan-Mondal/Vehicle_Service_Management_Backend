package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.ServiceType;

import com.capgemini.service.ServiceTypeServiceImpl;

@WebMvcTest(ServiceTypeController.class)
class ServiceTypeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceTypeServiceImpl servicetypeservice;

	@Test
	void findServiceTypetest() throws Exception {
		ServiceType e = new ServiceType();
		e.setService_desc("Apply Brakes");

		Mockito.when(servicetypeservice.findServiceTypeById(Mockito.anyInt())).thenReturn(e);
		mockMvc.perform(get("/api/servicetype/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.service_desc").value("Apply Brakes"));
	}
}
