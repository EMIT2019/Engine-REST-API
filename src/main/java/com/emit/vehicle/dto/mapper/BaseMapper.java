package com.emit.vehicle.dto.mapper;

import com.emit.vehicle.dto.DtoEntity;
import com.emit.vehicle.model.ModelEntity;

public interface BaseMapper<T extends ModelEntity, E extends DtoEntity> {
	E toGetDtoEntity(T entity);

	T toPostEntity(E dto);
}
