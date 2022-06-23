package com.emit.vehicle.service.vehicle;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.model.VehicleView;
import com.emit.vehicle.repository.VehicleRepository;
import com.emit.vehicle.repository.VehicleViewRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vRepository; 
	
	@Autowired
	private VehicleViewRepository vRepositoryView;
	
	@Override
	public List<Vehicle> getVehicles() {
		return vRepository.findAll();
	}
	
	//Getting a range of records (JPA Pagination)
	@Override
	public List<VehicleView> getPageVehicles(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return vRepositoryView.getAllVehiclesView(page);
	}
	
	@Override
	public VehicleView getVehicleById(Long id) {
		return vRepositoryView.findVehicleById(id);
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
