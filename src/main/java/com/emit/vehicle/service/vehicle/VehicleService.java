package com.emit.vehicle.service.vehicle;

import java.util.List;
import com.emit.vehicle.model.Vehicle;

public interface VehicleService {
	List<Vehicle> getVehicles();
	
	Vehicle getVehicleById(Long id);
	 
	Vehicle saveVehicle(Vehicle vehicle);  
	
	void deleteVehicle(Long id);
	
	Vehicle updateVehicle(Vehicle vehicle); 
}