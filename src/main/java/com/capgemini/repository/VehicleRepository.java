package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE from Vehicle where is_deleted = true")
	void deleteVehicleByIsDelete(boolean isDeleted);
}
