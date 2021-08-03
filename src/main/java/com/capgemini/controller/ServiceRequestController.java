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

import com.capgemini.entities.ServiceRequest;
import com.capgemini.service.ServiceRequestServiceImpl;

@RestController
@RequestMapping("/api/servicerequest/")
@CrossOrigin
public class ServiceRequestController {

	@Autowired
	private ServiceRequestServiceImpl serviceRequestServiceImpl;
	
	//creating the service request
	@PostMapping("/")
	public String create(@RequestBody ServiceRequest servicerequest) {
        return serviceRequestServiceImpl.createServiceRequest(servicerequest);
	}
	
	@PutMapping("/{service_req_id}")
	public String update(@PathVariable int service_req_id ,@RequestBody ServiceRequest servicerequest) {
		return serviceRequestServiceImpl.updateServiceRequest(service_req_id, servicerequest);
		}
	//finding all the details of all service request
	@GetMapping("/")
	public List<ServiceRequest> getRequest(){
		return serviceRequestServiceImpl.getRequest();
	}
	
	//finding request details by id
	@GetMapping("/{service_req_id}")
	public ServiceRequest getRequestById(@PathVariable Integer service_req_id) {
		return serviceRequestServiceImpl.getServiceRequestById(service_req_id);
	}
	
	@DeleteMapping("/{service_req_id}")
	public String deleteUser(@PathVariable int service_req_id) {
		return serviceRequestServiceImpl.deleteServiceRequest(service_req_id);
	}
}
