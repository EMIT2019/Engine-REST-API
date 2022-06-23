package com.emit.vehicle.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.model.VehicleView;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	@Query(value = "SELECT * FROM db_vehicles.vw_vehicles", nativeQuery = true)
	List<VehicleView> getAllVehiclesView();
}
