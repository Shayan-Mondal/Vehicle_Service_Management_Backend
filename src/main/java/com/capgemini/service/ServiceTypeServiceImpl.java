package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entities.ServiceType;
import com.capgemini.repository.ServiceTypeRepository;
@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	@Override
	public String createServiceType(ServiceType serviceType) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		serviceType.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		serviceType.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		//servicetype.date = java.time.LocalDateTime.now().format(formatter);
		serviceTypeRepository.save(serviceType);
		return "Service Type Created!!!";
	}

	@Override
	public String updateServiceType(int servicetype_id, ServiceType serviceType) {
		ServiceType dbServicetype=serviceTypeRepository.findById(servicetype_id).get();
		if(dbServicetype!=null) {
			
			dbServicetype.setService_desc(serviceType.getService_desc());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			serviceType.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
		serviceTypeRepository.save(dbServicetype);
			return "Service Type Updated!!!";
	}

	@Override
	public ServiceType findServiceTypeById(int servicetype_id) {
		ServiceType dbServicetype=serviceTypeRepository.findById(servicetype_id).get();
		System.out.println(dbServicetype);
		return(dbServicetype);
	}

	@Override
	public List<ServiceType> getRequest() {
		return serviceTypeRepository.findAll();
	}

	@Override
	public String deleteServiceType(int servicetype_id) {
		ServiceType dbServicetype=serviceTypeRepository.findById(servicetype_id).get();
		if(dbServicetype.isDeleted == false) {
			dbServicetype.isDeleted = true;
			serviceTypeRepository.save(dbServicetype);
		}
		return "Service Type Deleted";
	}

}
