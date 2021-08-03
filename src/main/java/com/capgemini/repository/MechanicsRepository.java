package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.Mechanics;

public interface MechanicsRepository extends JpaRepository<Mechanics,Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE from Mechanics where is_deleted = true")
	void deleteMechanicByIsDelete(boolean isDeleted);
}
