package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE from ServiceType where is_deleted = true")
	void deleteServiceTypeByIsDelete(boolean isDeleted);
}
