package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Mechanics;
import com.capgemini.repository.MechanicsRepository;
@Service
public class MechanicsServiceImpl implements IMechanicsService {
	@Autowired
	private MechanicsRepository mechanicsrepository;
	@Override
	public String createMechanics(Mechanics mechanics) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		mechanics.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		mechanics.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		//mechanics.date = java.time.LocalDateTime.now().format(formatter);
		mechanicsrepository.save(mechanics);
		
		return "Mechanic Details Added!!!";
	}

	@Override
	public String updateMechanics(int mechanicsId, Mechanics mechanics) {
		Mechanics dbMechanic=mechanicsrepository.findById(mechanicsId).get();
		if(dbMechanic!=null) {
			dbMechanic.setMechanicsName(mechanics.getMechanicsName());
			dbMechanic.setMechanicsAge(mechanics.getMechanicsAge());
			dbMechanic.setMechanicsMobile(mechanics.getMechanicsMobile());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			mechanics.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
			
		}
		mechanicsrepository.save(dbMechanic);
		return "Mechanic Updated!!!";
	}

	@Override
	public Mechanics findMechanicsbyId(int mechanicsId) {
		Mechanics dbMechanic=mechanicsrepository.findById(mechanicsId).get();
		System.out.println(dbMechanic);
		return(dbMechanic);
	}

	@Override
	public List<Mechanics> getRequest() {
		return mechanicsrepository.findAll();
	}

	@Override
	public String deleteMechanic(int mechanicsId) {
		Mechanics dbMechanic=mechanicsrepository.findById(mechanicsId).get();
		if(dbMechanic.isDeleted == false) {
			dbMechanic.isDeleted = true;
			mechanicsrepository.save(dbMechanic);
		}
		return "Mechanic Deleted";
	}

}
