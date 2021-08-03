package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "service_req_id", scope = Integer.class)
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer service_req_id;
	
	//Mapping with Vehicle class vehicle_reg_no will be done
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_reg_no",referencedColumnName="vehicle_reg_no")
	private Vehicle vehicle;
	
	private String price;
	
	//admin will change this status according to the service
	private String status;
	
	//mapping with mechanics class will be done through this
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mechanics_id",referencedColumnName="mechanicsId")
	private Mechanics mechanics;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_catalog_id", referencedColumnName="service_catalog_id")
	private ServiceCatalog serviceCatalog;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_type_id", referencedColumnName="service_id")
	private ServiceType servicetype;
	
	@Column(nullable = false)
	public boolean isDeleted = false;
	public String create_Date_Time;
	public String update_Date_Time;
	public String date;

	
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="vehicle_reg_no", referencedColumnName="vehicle_reg_no")
	//private Vehicle vehicle;
}
