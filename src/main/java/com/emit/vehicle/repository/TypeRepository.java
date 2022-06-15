package com.emit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emit.vehicle.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
	
}
