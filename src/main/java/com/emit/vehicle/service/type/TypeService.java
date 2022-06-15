package com.emit.vehicle.service.type;

import java.util.List;

import com.emit.vehicle.model.Type;

public interface TypeService {
	List<Type> getAllTypes();
	
	Type getTypeById(Long id);
	
	Type saveType(Type type);
	
	void deleteType(Long id);
	
	Type updateType(Type type); 
}
