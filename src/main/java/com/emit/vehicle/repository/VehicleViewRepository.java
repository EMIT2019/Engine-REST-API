package com.emit.vehicle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emit.vehicle.model.VehicleView;

public interface VehicleViewRepository extends ReadOnlyRepository<VehicleView, Long> {
	@Query(value = "SELECT * FROM db_vehicles.vw_vehicles", 
			countQuery = "SELECT count(*) FROM db_vehicles.vw_vehicles", 
			nativeQuery = true)
	List<VehicleView> getAllVehiclesView(Pageable page);
	
	@Query(value = "SELECT * FROM db_vehicles.vw_vehicles WHERE id_vehicle = :idVehicle", nativeQuery = true)
	VehicleView findVehicleById(Long idVehicle);
}
