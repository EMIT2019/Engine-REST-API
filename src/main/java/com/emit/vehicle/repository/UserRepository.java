package com.emit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emit.vehicle.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM db_vehicles.user WHERE username = :user_name AND password = :pass_word", nativeQuery = true)
	User validateUser(@Param("user_name") String username, @Param("pass_word") String password);
}
