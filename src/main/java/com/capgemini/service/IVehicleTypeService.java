package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.VehicleType;

public interface IVehicleTypeService {
String createVehicleType(VehicleType vehicleType);
String updateVehicleType(int vehicle_mod_id,VehicleType vehicleType);
VehicleType findVehicleTypeById(int vehicle_mod_id);
List<VehicleType> getRequest();
String deletevehicleType(int vehicle_mod_id);
}
