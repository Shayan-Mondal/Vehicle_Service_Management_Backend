package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE from ServiceRequest where is_deleted = true")
	void deleteServiceRequestByIsDelete(boolean isDeleted);
}
