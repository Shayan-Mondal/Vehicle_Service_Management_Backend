package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Mechanics;
import com.capgemini.entities.ServiceCatalog;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.ServiceType;
import com.capgemini.entities.Vehicle;
import com.capgemini.repository.MechanicsRepository;
import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceRequestRepository;
import com.capgemini.repository.ServiceTypeRepository;
import com.capgemini.repository.VehicleRepository;
@Service
public class ServiceRequestServiceImpl implements IServiceRequestService {

	@Autowired
	private ServiceRequestRepository serreqrepository;
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private ServiceCatalogRepository sercatrepo;
	
	@Autowired
	private MechanicsRepository mechanicsrepository;
	
	@Autowired
	private ServiceTypeRepository sertyperepository;
	
	@Override
	public String createServiceRequest(ServiceRequest servicerequest) {
		if(servicerequest.getVehicle()!=null) {
			Vehicle vehi=vehiclerepository.findById(servicerequest.getVehicle().getVehicle_reg_no()).get();
			servicerequest.setVehicle(vehi);
		}
		if(servicerequest.getServiceCatalog()!=null) {
			ServiceCatalog ser_cat=sercatrepo.findById(servicerequest.getServiceCatalog().getService_catalog_id()).get();
			servicerequest.setServiceCatalog(ser_cat);
		}
		if(servicerequest.getMechanics()!=null) {
			Mechanics mech=mechanicsrepository.findById(servicerequest.getMechanics().getMechanicsId()).get();
			servicerequest.setMechanics(mech);
		}
		if(servicerequest.getServicetype()!=null) {
			ServiceType ser=sertyperepository.findById(servicerequest.getServicetype().getService_id()).get();
			servicerequest.setServicetype(ser);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		servicerequest.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicerequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		servicerequest.date = java.time.LocalDateTime.now().format(formatter);
		
		serreqrepository.save(servicerequest);
		return "Request Added!!!";
	}

	@Override
	public String updateServiceRequest(int service_req_id, ServiceRequest servicerequest) {
		ServiceRequest dbServiceRequest= serreqrepository.findById(service_req_id).get();
		if(dbServiceRequest!=null) {
			
			dbServiceRequest.setStatus(servicerequest.getStatus());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			servicerequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
		serreqrepository.save(dbServiceRequest);
			return "Status Updated";
	}

	@Override
	public ServiceRequest getServiceRequestById(int service_req_id) {
		return serreqrepository.findById(service_req_id).get();
	}

	@Override
	public List<ServiceRequest> getRequest() {
		return serreqrepository.findAll();
	}

	@Override
	public String deleteServiceRequest(int service_req_id) {
		ServiceRequest dbServiceRequest= serreqrepository.findById(service_req_id).get();
		if(dbServiceRequest.isDeleted == false) {
			dbServiceRequest.isDeleted = true;
			serreqrepository.save(dbServiceRequest);
		}
		return "Service Request Deleted";
	}

}
