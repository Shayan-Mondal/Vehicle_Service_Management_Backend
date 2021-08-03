package com.capgemini.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.Vehicle;

import com.capgemini.service.VehicleServiceImpl;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleServiceImpl vehiclesservice;

	@Test
	void findVehicaltest() throws Exception {
		Vehicle ud = new Vehicle();
		ud.setVehicle_color("Black");
		ud.setVehicle_man_yr("1998");

		Mockito.when(vehiclesservice.findVehicleById(Mockito.anyInt())).thenReturn(ud);
		mockMvc.perform(get("/api/vehicle/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.vehicle_color").value("Black"));
	}

}

