package com.emit.vehicle.service.type;

import java.util.List;
import java.util.Optional;

import com.emit.vehicle.model.ModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository tService;

    public TypeServiceImpl(TypeRepository typeService){
        this.tService = typeService;
    }


    @Override
    public List<Type> getAllTypes() {
        return tService.findAll();
    }

    @Override
    public List<Type> getPageType(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Type getTypeById(Long id) {
        return null;
    }

    @Override
    public Type saveType(Type type) {
        return null;
    }

    @Override
    public void deleteType(Long id) {

    }

    @Override
    public Type updateType(Type type) {
        return null;
    }
}
