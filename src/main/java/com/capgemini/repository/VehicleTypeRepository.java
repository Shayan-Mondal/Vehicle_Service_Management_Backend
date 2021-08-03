package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE from VehicleType where is_deleted = true")
	void deleteVehicleTypeByIsDelete(boolean isDeleted);
}
