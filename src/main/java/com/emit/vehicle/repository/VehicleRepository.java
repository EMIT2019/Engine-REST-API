package com.emit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emit.vehicle.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	/*@Query("SELECT * FROM db_vehicles.vw_vehicles")
	public List<Vehicles>*/
}
