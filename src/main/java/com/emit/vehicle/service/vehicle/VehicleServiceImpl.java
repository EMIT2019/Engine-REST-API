package com.emit.vehicle.service.vehicle;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	//Getting a range of records (JPA Pagination)
	@Override
	public List<Vehicle> getPageVehicles(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return vRepository.findAll(page).getContent();
	}
	
	@Override
	public Vehicle getVehicleById(Long id) {
		Optional<Vehicle> vehicle = vRepository.findById(id);
		
		if(vehicle.isPresent()) {
			return vehicle.get();
		}
		
		throw new RuntimeException("The vehicle with id "+id+" does not exists.");
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
