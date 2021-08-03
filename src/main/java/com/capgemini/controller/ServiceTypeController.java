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

import com.capgemini.entities.ServiceType;
import com.capgemini.service.ServiceTypeServiceImpl;

@RestController
@RequestMapping("/api/servicetype/")
@CrossOrigin
public class ServiceTypeController {
	
	@Autowired
	private ServiceTypeServiceImpl serviceTypeServiceImpl;

	@PostMapping("/")
	public String createServiceType(@RequestBody ServiceType servicetype) {
     return serviceTypeServiceImpl.createServiceType(servicetype);
	}
	
	@PutMapping("/{service_id}")
	public String update(@PathVariable int service_id,@RequestBody ServiceType servicetype ) {
		return serviceTypeServiceImpl.updateServiceType(service_id, servicetype);
		}
	@GetMapping("/{service_id}")
	public ServiceType findById(@PathVariable int service_id ) {
		return serviceTypeServiceImpl.findServiceTypeById(service_id);
	}
	
	@GetMapping("/")
	public List<ServiceType> getRequest(){
		return serviceTypeServiceImpl.getRequest();
	}
	
	@DeleteMapping("/{service_id}")
	public String deleteUser(@PathVariable int service_id) {
	
		return serviceTypeServiceImpl.deleteServiceType(service_id);
	}
	
}
