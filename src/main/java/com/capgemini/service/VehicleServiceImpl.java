package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.UserDetails;
import com.capgemini.entities.Vehicle;
import com.capgemini.entities.VehicleType;
import com.capgemini.repository.UserDetailsRepository;
import com.capgemini.repository.VehicleRepository;
import com.capgemini.repository.VehicleTypeRepository;
@Service
public class VehicleServiceImpl implements IVehicleService {
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private UserDetailsRepository userdetailsrepository;
	
	@Autowired
	private VehicleTypeRepository vehicletyperepository;
	@Override
	public String createVehicle(Vehicle vehicle) {
		
		if(vehicle.getUserdetails()!=null) {
			UserDetails user=userdetailsrepository.findById(vehicle.getUserdetails().getUserId()).get();
			vehicle.setUserdetails(user);
		}
		if(vehicle.getVehicletype()!=null) {
			VehicleType vehi=vehicletyperepository.findById(vehicle.getVehicletype().getVehicle_mod_id()).get();
			vehicle.setVehicletype(vehi);
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		vehicle.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehicle.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		vehiclerepository.save(vehicle);
		return "Vehicle Added!!!";
	}

	@Override
	public String updateVehicle(int vehicle_reg_no, Vehicle vehicle) {
		Vehicle dbVehicle=vehiclerepository.findById(vehicle_reg_no).get();
		if(dbVehicle!=null) {
			dbVehicle.setUserdetails(vehicle.getUserdetails());
			dbVehicle.setVehicle_color(vehicle.getVehicle_color());
			dbVehicle.setVehicle_desc(vehicle.getVehicle_desc());
			dbVehicle.setVehicle_man_yr(vehicle.getVehicle_desc());
			dbVehicle.setVehicletype(vehicle.getVehicletype());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			vehicle.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			vehiclerepository.save(dbVehicle);
			return "Vehicle Updated!!!";
	}

	@Override
	public Vehicle findVehicleById(int vehicle_reg_no) {
		Vehicle dbVehicle=vehiclerepository.findById(vehicle_reg_no).get();
		System.out.println(dbVehicle);
		return dbVehicle;
	}

	@Override
	public List<Vehicle> getRequest() {
		return vehiclerepository.findAll();
	}

	@Override
	public String deleteVehicleDetails(int vehicle_reg_no) {
		Vehicle dbVehicle=vehiclerepository.findById(vehicle_reg_no).get();
		if(dbVehicle.isDeleted == false) {
			dbVehicle.isDeleted = true;
			vehiclerepository.save(dbVehicle);
		}
		return "Vehicle Deleted";
	}

}
