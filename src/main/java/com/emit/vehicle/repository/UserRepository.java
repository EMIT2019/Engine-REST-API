package com.emit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emit.vehicle.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
