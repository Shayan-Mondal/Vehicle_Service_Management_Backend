package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.ServiceRequest;

public interface IServiceRequestService {
String createServiceRequest(ServiceRequest servicerequest);
String updateServiceRequest(int serviceRequest_id,ServiceRequest servicerequest);
ServiceRequest getServiceRequestById(int service_req_id);
List<ServiceRequest> getRequest();
String deleteServiceRequest(int service_req_id );
}
