package com.emit.vehicle.service.vehicle;

import java.util.List;

import org.springframework.data.domain.Page;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.model.VehicleView;

public interface VehicleService {
	List<Vehicle> getVehicles();
	
	List<VehicleView> getPageVehicles(int pageNumber, int pageSize);
	
	VehicleView getVehicleById(Long id);
	 
	Vehicle saveVehicle(Vehicle vehicle);  
	
	void deleteVehicle(Long id);
	
	Vehicle updateVehicle(Vehicle vehicle); 
}
