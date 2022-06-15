package com.emit.vehicle.service.type;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeRepository tRepository;

	@Override
	public List<Type> getAllTypes() {
		return tRepository.findAll();
	}

	@Override
	public Type getTypeById(Long id) {
		Optional<Type> type = tRepository.findById(id);
		
		if(type.isPresent()) {
			return type.get();
		}
		
		throw new RuntimeException("Type with id "+id+" wasn't found");
	}

	@Override
	public Type saveType(Type type) {
		return tRepository.save(type);
	}

	@Override
	public void deleteType(Long id) {
		tRepository.deleteById(id);
	}

	@Override
	public Type updateType(Type type) {
		return tRepository.save(type);
	}

}
