package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceCatalog;
import com.capgemini.service.ServiceCatalogServiceImpl;

@RestController
@RequestMapping("/api/servicecatalog/")
public class ServiceCatalogController {
	
	@Autowired
	private ServiceCatalogServiceImpl serviceCatalogServiceImpl;

	@PostMapping("/")
	public String create(@RequestBody ServiceCatalog servicecatalog) {
     return serviceCatalogServiceImpl.createServiceCatalog(servicecatalog);
	}
	
	@GetMapping("/")
	public List<ServiceCatalog> getRequest(){
		return serviceCatalogServiceImpl.getRequest();
	}
}
