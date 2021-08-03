package com.capgemini.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class ServiceRequestDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_req_id",referencedColumnName="service_req_id")
	private ServiceRequest service_request;
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_catalog_id",referencedColumnName="service_catalog_id")
	private ServiceCatalog service_catalog;*/
	
	private String price;
	
}
