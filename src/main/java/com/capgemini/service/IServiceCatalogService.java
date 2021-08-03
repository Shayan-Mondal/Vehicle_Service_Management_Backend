package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.ServiceCatalog;

public interface IServiceCatalogService {
String createServiceCatalog(ServiceCatalog serviceCatalog);
List<ServiceCatalog> getRequest();
}
