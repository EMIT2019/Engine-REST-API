package com.emit.vehicle.service.type;

import java.util.List;
import java.util.Optional;

import com.emit.vehicle.repository.specification.SearchCriteria;
import com.emit.vehicle.repository.specification.TypeSpecification;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import com.emit.vehicle.repository.specification.parameters.TypeParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository tRepository;

    public TypeServiceImpl(TypeRepository typeRepository){
        this.tRepository = typeRepository;
    }

    @Override
    public List<Type> getAll() {
        return tRepository.findAll();
    }

    @Override
    public Type getById(Long id) {
        Optional<Type> type = tRepository.findById(id);

        if(type.isPresent()){
            return type.get();
        }

        throw new RuntimeException("The item with id "+id+" doesn't exists");
    }

    @Override
    public List<Type> getPage(Integer pageNumber, Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return tRepository.findAll(page).getContent();
    }

    @Override
    public Type save(Type entity) {
        return tRepository.save(entity);
    }

    @Override
    public Type update(Type entity) {
        return tRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        tRepository.deleteById(id);
    }

    @Override
    public List<Type> getTypeByGivenName(String typeName) {
        SearchCriteria criteria = new SearchCriteria(
                TypeParameter.TYPE_NAME_FIELD.getValue(),
                OperationParameter.EQUALS_TO.getValue(),
                typeName
        );

        return tRepository.findAll(new TypeSpecification(criteria));
    }
}