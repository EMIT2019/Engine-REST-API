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

	private final VehicleRepository vRepository;

	public VehicleServiceImpl(VehicleRepository vehicleRepository){
		this.vRepository = vehicleRepository;
	}

	@Override
	public List<Vehicle> getAll() {
		return vRepository.findAll();
	}

	@Override
	public Vehicle getById(Long id) {
		Optional<Vehicle> vehicle = vRepository.findById(id);

		if(vehicle.isPresent()){
			return vehicle.get();
		}
		throw new RuntimeException("The item with the id "+id+" doesn't exists");
	}

	@Override
	public List<Vehicle> getPage(Integer pageNumber, Integer pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return vRepository.findAll(page).getContent();
	}

	@Override
	public Vehicle save(Vehicle entity) {
		return vRepository.save(entity);
	}

	@Override
	public Vehicle update(Vehicle entity) {
		return vRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		vRepository.deleteById(id);
	}
}
