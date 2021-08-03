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

import com.capgemini.entities.Enquiry;
import com.capgemini.service.EnquiryServiceImpl;

@RestController
@RequestMapping("/api/enquiry")
@CrossOrigin
public class EnquiryController {
	
	@Autowired
	private EnquiryServiceImpl enquiryServiceImpl;
	
	@PostMapping("/")
	public String create(@RequestBody Enquiry enquiry) {
      return enquiryServiceImpl.createEnquiry(enquiry);
	}
	
	@PutMapping("/{enquiry_id}")
	public String update(@PathVariable int enquiry_id,@RequestBody Enquiry enquiry) {
		return enquiryServiceImpl.updateEnquiry(enquiry_id, enquiry);
}
	@GetMapping("/{enquiry_id}")
	public Enquiry findById(@PathVariable int enquiry_id) {
		return enquiryServiceImpl.findEnquiryById(enquiry_id);
	}
	
	@GetMapping("/")
	public List<Enquiry> getRequest(){
		return enquiryServiceImpl.getRequest();
	}
	
	@DeleteMapping("/{enquiry_id}")
	public String deleteEnquiry(@PathVariable int enquiry_id) {
		return enquiryServiceImpl.deleteEnquiryDetails(enquiry_id);
	}
}
