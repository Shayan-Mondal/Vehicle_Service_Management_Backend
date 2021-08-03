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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "enquiry_id", scope = Integer.class)
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiry_id;
	private String enquiry_desc;
	private String admin_response;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName="userId")
	private UserDetails user_details;
	
	@Column(nullable = false)
	public boolean isDeleted = false;
	public String create_Date_Time;
	public String update_Date_Time;
	
}
