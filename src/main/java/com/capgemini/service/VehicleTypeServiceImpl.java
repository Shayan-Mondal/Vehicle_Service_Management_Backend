package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.VehicleType;
import com.capgemini.repository.VehicleTypeRepository;

@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicletyperepository;
	
	@Override
	public String createVehicleType(VehicleType vehicleType) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		vehicleType.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehicleType.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		//vehicletype.date = java.time.LocalDateTime.now().format(formatter);
		vehicletyperepository.save(vehicleType);
		return "Vehicle Type Added";
		
	}

	@Override
	public String updateVehicleType(int vehicle_mod_id, VehicleType vehicleType) {
		VehicleType dbVehicletype=vehicletyperepository.findById(vehicle_mod_id).get();
		if(dbVehicletype!=null) {
			
			dbVehicletype.setVehicle_model_name(vehicleType.getVehicle_model_name());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			vehicleType.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			vehicletyperepository.save(dbVehicletype);
			return "Vehicle Updated!!!";
	}

	@Override
	public VehicleType findVehicleTypeById(int vehicle_mod_id) {
		VehicleType dbVehicletype=vehicletyperepository.findById(vehicle_mod_id).get();
		System.out.println(dbVehicletype);
		return(dbVehicletype);
	}

	@Override
	public List<VehicleType> getRequest() {
		return vehicletyperepository.findAll();
	}

	@Override
	public String deletevehicleType(int vehicle_mod_id) {
		VehicleType dbVehicletype=vehicletyperepository.findById(vehicle_mod_id).get();
		if(dbVehicletype.isDeleted == false) {
			dbVehicletype.isDeleted = true;
			vehicletyperepository.save(dbVehicletype);
		}
		return "VehicleType Deleted";
	}

}
