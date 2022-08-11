package com.emit.vehicle.repository;

import com.emit.vehicle.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends ModelEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
