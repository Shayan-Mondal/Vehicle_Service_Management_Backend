package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.ServiceRequestDetail;
import com.capgemini.repository.ServiceRequestDetailRepository;
import com.capgemini.repository.ServiceRequestRepository;
@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private ServiceRequestDetailRepository srdrepository;
	
	@Autowired
	private ServiceRequestRepository ser_reqrepository;
	
	/*@Autowired
	private ServiceCatalogRepository sercatrepository;*/
	@Override
	public String generateRequestDetails(ServiceRequestDetail serviceRequestDetali) {
		if(serviceRequestDetali.getService_request()!=null) {
			ServiceRequest serreq=ser_reqrepository.findById(serviceRequestDetali.getService_request().getService_req_id()).get();
			serviceRequestDetali.setService_request(serreq);
		}
		/*if(servicerequestdetail.getServicecatalog()!=null) {
			ServiceCatalog sercat=sercatrepository.findById(servicerequestdetail.getServicecatalog().getService_catalog_id()).get();
			servicerequestdetail.setServicecatalog(sercat);
		}*/
		
		srdrepository.save(serviceRequestDetali);
		return "Service Details generated!!!";
	}

}
