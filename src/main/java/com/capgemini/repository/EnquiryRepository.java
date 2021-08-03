package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry,Integer> {
	@Transactional
	@Modifying
	@Query(value = "DELETE from Enquiry where is_deleted = true")
	void deleteEnquiryByIsDelete(boolean isDeleted);

}
