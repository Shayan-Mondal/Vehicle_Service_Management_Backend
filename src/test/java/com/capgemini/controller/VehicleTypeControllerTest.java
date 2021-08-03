package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.VehicleType;

import com.capgemini.service.VehicleTypeServiceImpl;

@WebMvcTest(VehicleTypeController.class)
class VehicleTypeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleTypeServiceImpl vehicletypesservice;

	@Test
	void findVehicleTypetest() throws Exception {
		VehicleType ud = new VehicleType();
		ud.setVehicle_model_name("suv");

		Mockito.when(vehicletypesservice.findVehicleTypeById(Mockito.anyInt())).thenReturn(ud);
		mockMvc.perform(get("/api/vehicletype/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.vehicle_model_name").value("suv"));
	}

}
