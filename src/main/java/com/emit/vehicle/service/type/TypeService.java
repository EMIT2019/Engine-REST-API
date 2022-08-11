package com.emit.vehicle.service.type;

import java.util.List;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.service.BaseService;

public interface TypeService extends BaseService<Type, Long> {
    List<Type> getTypeByGivenName(String typeName);
}
