package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.ServiceRequestDetail;

public interface ServiceRequestDetailRepository extends JpaRepository<ServiceRequestDetail,Integer> {

}
