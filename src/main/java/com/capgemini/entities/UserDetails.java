package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId", scope = Integer.class)
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String userMobile;
	@Column(nullable = false)
	private String userPassword;
	@Column(nullable = false)
	private String userType;
	
	@Column(nullable = false)
	public boolean isDeleted = false;
	public String create_Date_Time;
	public String update_Date_Time;
	

}