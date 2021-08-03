package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.Enquiry;

import com.capgemini.service.EnquiryServiceImpl;

@WebMvcTest(EnquiryController.class)
class EnquiryControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EnquiryServiceImpl enquirysservice;

	@Test
	void findEnquirytest() throws Exception {
		Enquiry e = new Enquiry();
		e.setEnquiry_desc("Brake failure");

		Mockito.when(enquirysservice.findEnquiryById(Mockito.anyInt())).thenReturn(e);
		mockMvc.perform(get("/api/enquiry/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.enquiry_desc").value("Brake failure"));
	}
}