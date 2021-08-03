package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceRequestDetail;
import com.capgemini.repository.EnquiryRepository;
import com.capgemini.repository.MechanicsRepository;
import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceRequestDetailRepository;
import com.capgemini.repository.ServiceRequestRepository;
import com.capgemini.repository.ServiceTypeRepository;
import com.capgemini.repository.UserDetailsRepository;
import com.capgemini.repository.VehicleRepository;
import com.capgemini.repository.VehicleTypeRepository;
import com.capgemini.service.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private EnquiryRepository enquiryrepository;
	
	@Autowired
	private MechanicsRepository mechanicrepository;
	
	@Autowired
	private ServiceCatalogRepository sercatrepository;

	@Autowired
	private ServiceRequestRepository serreqrepository;
	
	@Autowired
	private ServiceRequestDetailRepository srdrepository;
	
	@Autowired
	private ServiceTypeRepository servicetyperepository;
	
	@Autowired
	private UserDetailsRepository userdetailrepository;
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private VehicleTypeRepository vehicletyperepository;
	
	@PostMapping("/generatedetail")
	public String generateRequestdetail(@RequestBody ServiceRequestDetail servicerequestdetail) {
     return adminServiceImpl.generateRequestDetails(servicerequestdetail);
	}
	
	@DeleteMapping("/metaclean")
	public String metaDataCleanUp() {
		enquiryrepository.deleteEnquiryByIsDelete(true);
		serreqrepository.deleteServiceRequestByIsDelete(true);
		servicetyperepository.deleteServiceTypeByIsDelete(true);
		//sercatrepository.deleteServiceCatalogByIsDelete(false);
		vehicletyperepository.deleteVehicleTypeByIsDelete(true);
		vehiclerepository.deleteVehicleByIsDelete(true);
		mechanicrepository.deleteMechanicByIsDelete(true);
		userdetailrepository.deleteUserDetailsByIsDelete(true);
		return "Done";
	}
	
}
