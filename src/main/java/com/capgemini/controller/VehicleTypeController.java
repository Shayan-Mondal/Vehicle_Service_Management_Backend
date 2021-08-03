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


import com.capgemini.entities.VehicleType;
import com.capgemini.service.VehicleTypeServiceImpl;

@RestController
@RequestMapping("/api/vehicletype/")
@CrossOrigin
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeServiceImpl vehicleServiceImp;
	
	@PostMapping("/")
	public String create(@RequestBody VehicleType vehicletype) {
		return vehicleServiceImp.createVehicleType(vehicletype);
	}
	
	@PutMapping("/{vehicle_mod_id}")
	public String update(@PathVariable int vehicle_mod_id,@RequestBody VehicleType vehicletype ) {
			return vehicleServiceImp.updateVehicleType(vehicle_mod_id, vehicletype);
		}
	@GetMapping("/{vehicle_mod_id}")
	public VehicleType findById(@PathVariable int vehicle_mod_id ) {
		return vehicleServiceImp.findVehicleTypeById(vehicle_mod_id);
	}
	
	@GetMapping("/")
	public List<VehicleType> getRequest(){
		return vehicleServiceImp.getRequest();
	}
	@DeleteMapping("/{vehicle_mod_id}")
	public String deleteUser(@PathVariable int vehicle_mod_id) {
		
		return vehicleServiceImp.deletevehicleType(vehicle_mod_id);
	}

}
