package com.emit.vehicle.service.vehicle;

import java.util.*;

import com.emit.vehicle.repository.specification.SearchCriteria;
import com.emit.vehicle.repository.specification.VehicleSpecification;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import com.emit.vehicle.repository.specification.parameters.VehicleParameter;
import com.emit.vehicle.service.parameters.GlobalServiceParameters;
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
	public List<Vehicle> getPage(Integer pageNumber) {
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.HUGE_RECORDS_AMOUNT.getValue());
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
	public List<Vehicle> getAllByGivenBrand(Integer pageNumber, String brandName) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_BRAND_FIELD.getValue(),
				OperationParameter.EQUALS_TO.getValue(),
				brandName
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByGivenModel(Integer pageNumber, String modelName) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_MODEL_FIELD.getValue(),
				OperationParameter.EQUALS_TO.getValue(),
				modelName
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.MEDIUM_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByGivenType(Integer pageNumber, String typeName) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_TYPE_FIELD.getValue(),
				OperationParameter.EQUALS_TO.getValue(),
				typeName
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.MEDIUM_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByFasterThan(Integer pageNumber, Long topSpeed) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_TS_FIELD.getValue(),
				OperationParameter.GREATER_THAN.getValue(),
				topSpeed
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByHorsePowerGreaterThan(Integer pageNumber, Long horsepower) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_HP_FIELD.getValue(),
				OperationParameter.GREATER_THAN.getValue(),
				horsepower
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public Pageable pageableBuilder(Integer pageNumber, Integer pageSize) {
		return PageRequest.of(pageNumber, pageSize);
	}
}
