package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

import lombok.Data;

@Entity
@Data
public class Mechanics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mechanicsId;
	@Column(nullable=false)
	private String mechanicsName;
	@Column(nullable=false)
	private int mechanicsAge;
	@Column(nullable=false)
	private String mechanicsMobile;
	private LocalDate joiningDate =LocalDate.now();
	
	@Column(nullable = false)
	public boolean isDeleted = false;
	public String create_Date_Time;
	public String update_Date_Time;
	
	

}
