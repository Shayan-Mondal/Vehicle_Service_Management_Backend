package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.Mechanics;

import com.capgemini.service.MechanicsServiceImpl;

@WebMvcTest(MechanicsController.class)
class MechanicsControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MechanicsServiceImpl mechanicsservice;

	@Test
	void findmechanicstest() throws Exception {
		Mechanics ud = new Mechanics();
		ud.setMechanicsName("Aneesh");
		ud.setMechanicsMobile("9763451234");

		Mockito.when(mechanicsservice.findMechanicsbyId(Mockito.anyInt())).thenReturn(ud);
		mockMvc.perform(get("/api/mechanics/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.mechanicsName").value("Aneesh"));
	}

	/*
	 * @Test void createMechanicsTest() throws Exception { Mechanics ud = new
	 * Mechanics(); ud.setMechanicsName("Aneesh");
	 * ud.setMechanicsMobile("9763451234");
	 * Mockito.when(mechanicsservice.createMechanics(Mockito.any())).thenReturn(ud);
	 * mockMvc.perform(post("/api/mechanics/").contentType(MediaType.
	 * APPLICATION_JSON) .content(new ObjectMapper().writeValueAsString(ud)))
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.mechanicsName").value("Aneesh"))
	 * ; }
	 */

}
