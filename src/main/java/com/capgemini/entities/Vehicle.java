package com.capgemini.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicle_reg_no", scope = Integer.class)
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vehicle_reg_no;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName="userId")
	private UserDetails userdetails;
	private String vehicle_color;
	private String vehicle_man_yr;
	private String vehicle_desc;
	private String vehicle_number;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_mod_id",referencedColumnName="vehicle_mod_id")
	//private Integer vehicle_mod_id;
	private VehicleType vehicletype;
	
	@Column(nullable = false)
	public boolean isDeleted = false;
	public String create_Date_Time;
	public String update_Date_Time;
	
	
}
