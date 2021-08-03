package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.ServiceCatalog;

public interface ServiceCatalogRepository extends JpaRepository<ServiceCatalog,Integer> {

	/*@Transactional
	@Modifying
	@Query(value = "DELETE from ServiceCatalog where is_deleted = true")
	void deleteServiceCatalogByIsDelete(boolean isDeleted);*/
}
