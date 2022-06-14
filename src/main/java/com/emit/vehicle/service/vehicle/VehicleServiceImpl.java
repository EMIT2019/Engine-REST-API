package com.emit.vehicle.service.vehicle;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vRepository; 
	
	@Override
	public List<Vehicle> getVehicles() {
		return vRepository.findAll();
	}
	
	@Override
	public Vehicle getVehicleById(Long id) {
		Optional<Vehicle> vehicle = vRepository.findById(id);
		
		if(vehicle.isPresent()) {
			return vehicle.get();
		};
		
		throw new RuntimeException("Vehicle with id "+id+" wasn't found.");
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vRepository.save(vehicle);
	}
	
	@Override
	public void deleteVehicle(Long id) {
		vRepository.deleteById(id);
	}
	
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vRepository.save(vehicle);
	}
}
