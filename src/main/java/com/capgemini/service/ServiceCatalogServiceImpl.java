package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.ServiceCatalog;
import com.capgemini.entities.ServiceType;
import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceTypeRepository;
@Service
public class ServiceCatalogServiceImpl implements IServiceCatalogService {
	@Autowired
	private ServiceCatalogRepository sercatrepository;
	@Autowired
	private ServiceTypeRepository sertyperepository;

	@Override
	public String createServiceCatalog(ServiceCatalog serviceCatalog) {
		if(serviceCatalog.getServicetype()!=null) {
			ServiceType sertype=sertyperepository.findById(serviceCatalog.getServicetype().getService_id()).get();
			serviceCatalog.setServicetype(sertype);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		serviceCatalog.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		serviceCatalog.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		//serviceCatalog.date = java.time.LocalDateTime.now().format(formatter);
		sercatrepository.save(serviceCatalog);
		return "Service Catalog created!!!";
	}

	@Override
	public List<ServiceCatalog> getRequest() {
		return sercatrepository.findAll();
	}

}
