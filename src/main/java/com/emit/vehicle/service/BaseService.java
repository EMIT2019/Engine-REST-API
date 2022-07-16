package com.emit.vehicle.service;

import com.emit.vehicle.model.ModelEntity;

import java.util.List;

public interface BaseService<T extends ModelEntity, ID> {
    List<T> getAll();

    T getById(ID id);

    T save(T entity);

    T update(T entity);

    void delete(ID id);
}
