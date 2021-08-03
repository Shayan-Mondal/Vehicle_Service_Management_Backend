package com.capgemini.entities;



import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "service_catalog_id", scope = Integer.class)
public class ServiceCatalog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer service_catalog_id;
	
	//mapping with vehicle type will be done here
	private Integer vehicle_model_id;
	
	//mapping with service type will be done
	private String service_price;
	
	//@OneToMany(mappedBy="serviceCatalog")
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_id",referencedColumnName="service_id")
	private ServiceType servicetype;
	
	public String create_Date_Time;
	public String update_Date_Time;
	//public String date;

}
