package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.entities.Vehicle;
import com.capgemini.service.VehicleServiceImpl;

@RestController
@RequestMapping("/api/vehicle/")
@CrossOrigin
public class VehicleController {
	
	@Autowired
	private VehicleServiceImpl vehicleServiceImpl;

	@PostMapping("/")
	public String create(@RequestBody Vehicle vehicle) {
		return vehicleServiceImpl.createVehicle(vehicle);
	}
	
	@PutMapping("/{vehicle_reg_no}")
	public String update(@PathVariable int vehicle_reg_no,@RequestBody Vehicle vehicle ) {
			return vehicleServiceImpl.updateVehicle(vehicle_reg_no, vehicle);
		}
	@GetMapping("/{vehicle_reg_no}")
	public Vehicle findById(@PathVariable int vehicle_reg_no ) {
		return vehicleServiceImpl.findVehicleById(vehicle_reg_no);
	}
	
	@GetMapping("/")
	public List<Vehicle> getRequest(){
		return vehicleServiceImpl.getRequest();
	}
	
	@DeleteMapping("/{vehicle_reg_no}")
	public String deleteVehicle(@PathVariable int vehicle_reg_no) {
		return vehicleServiceImpl.deleteVehicleDetails(vehicle_reg_no);
	}
}
