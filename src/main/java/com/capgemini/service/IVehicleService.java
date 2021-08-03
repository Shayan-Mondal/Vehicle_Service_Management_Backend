package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Vehicle;

public interface IVehicleService {
String createVehicle(Vehicle vehicle);
String updateVehicle(int vehicle_reg_no,Vehicle vehicle);
Vehicle findVehicleById(int vehicle_reg_no);
List<Vehicle> getRequest();
String deleteVehicleDetails(int vehicle_reg_no );
}
