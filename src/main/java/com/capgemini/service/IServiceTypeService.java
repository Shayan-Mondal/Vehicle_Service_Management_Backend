package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.ServiceType;

public interface IServiceTypeService {
String createServiceType(ServiceType serviceType);
String updateServiceType(int servicetype_id,ServiceType serviceType);
ServiceType findServiceTypeById(int servicetype_id);
List<ServiceType> getRequest();
String deleteServiceType(int servicetype_id);
}
