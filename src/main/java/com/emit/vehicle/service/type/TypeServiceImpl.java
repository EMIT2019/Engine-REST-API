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
    public List<Type> getAll() {
        return tService.findAll();
    }

    @Override
    public Type getById(Long id) {
        Optional<Type> type = tService.findById(id);

        if(type.isPresent()){
            return type.get();
        }

        throw new RuntimeException("The item with id "+id+" doesn't exists");
    }

    @Override
    public List<Type> getPage(Integer pageNumber, Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return tService.findAll(page).getContent();
    }

    @Override
    public Type save(Type entity) {
        return tService.save(entity);
    }

    @Override
    public Type update(Type entity) {
        return tService.save(entity);
    }

    @Override
    public void delete(Long id) {
        tService.deleteById(id);
    }
}
