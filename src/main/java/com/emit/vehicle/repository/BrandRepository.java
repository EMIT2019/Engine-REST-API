package com.emit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emit.vehicle.model.Brand;

@Repository
public interface BrandRepository extends BaseRepository<Brand, Long> {
}
