package com.emit.vehicle.service.vehicle;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emit.vehicle.repository.specification.SearchCriteria;
import com.emit.vehicle.repository.specification.VehicleSpecification;
import com.emit.vehicle.repository.specification.builders.VehicleSpecificationBuilder;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import com.emit.vehicle.repository.specification.parameters.VehicleParameter;
import com.emit.vehicle.service.parameters.GlobalServiceParameters;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
	public List<Vehicle> getAllByGivenBrand(Integer pageNumber, String brandKey) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_BRAND_FIELD.getValue(),
				OperationParameter.EQUALS_TO,
				brandKey
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByGivenModel(Integer pageNumber, String modelName) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_MODEL_FIELD.getValue(),
				OperationParameter.EQUALS_TO,
				modelName
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.MEDIUM_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByGivenType(Integer pageNumber, String typeKey) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_TYPE_FIELD.getValue(),
				OperationParameter.EQUALS_TO,
				typeKey
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.MEDIUM_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> getAllByFasterThan(Integer pageNumber, Long topSpeed) {
		SearchCriteria criteria = new SearchCriteria(
				VehicleParameter.VEHICLE_TS_FIELD.getValue(),
				OperationParameter.GREATER_THAN,
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
				OperationParameter.GREATER_THAN,
				horsepower
		);

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());

		return vRepository.findAll(new VehicleSpecification(criteria), page).getContent();
	}

	@Override
	public List<Vehicle> globalVehicleSearch(Integer pageNumber, String searchParams) {
		VehicleSpecificationBuilder builder = new VehicleSpecificationBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Matcher matcher = pattern.matcher(searchParams + ",");

		while(matcher.find()){
			System.out.println(matcher.group(1) +" "+ matcher.group(2) +" "+ matcher.group(3));
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		//Paging for vehicle search
		Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());

		Specification<Vehicle> spec = builder.build();
		return vRepository.findAll(spec, page).getContent();
	}

	@Override
	public Pageable pageableBuilder(Integer pageNumber, Integer pageSize) {
		return PageRequest.of(pageNumber, pageSize);
	}
}
