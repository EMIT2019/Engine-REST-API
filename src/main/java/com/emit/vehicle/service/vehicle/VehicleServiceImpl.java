package com.emit.vehicle.service.vehicle;

import java.util.*;

import com.emit.vehicle.repository.specification.SearchCriteria;
import com.emit.vehicle.repository.specification.VehicleSpecification;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import com.emit.vehicle.repository.specification.parameters.VehicleParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

	@Override
	public List<Vehicle> getAllByGivenBrand(String brandName) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_BRAND_FIELD.getValue(),
				OperationParameter.EQUALS_TO.getValue(),
				brandName
		);

		return vRepository.findAll(new VehicleSpecification(criteria));
	}

	@Override
	public List<Vehicle> getAllByGivenModel(String modelName) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_MODEL_FIELD.getValue(),
				OperationParameter.EQUALS_TO.getValue(),
				modelName
		);

		return vRepository.findAll(new VehicleSpecification(criteria));
	}
}
