package com.emit.vehicle.repository.specification;

import com.emit.vehicle.model.Type;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import jdk.dynalink.Operation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TypeSpecification implements Specification<Type> {

    private final SearchCriteria criteria;

    public TypeSpecification(SearchCriteria searchCriteria){
        this.criteria = searchCriteria;
    }

    @Override
    public Specification<Type> and(Specification<Type> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Type> or(Specification<Type> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Type> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if(criteria.getOperation() == OperationParameter.EQUALS_TO){
            if(root.get(criteria.getKey()).getJavaType() == String.class){
                return criteriaBuilder.like(
                        root.<String> get(criteria.getKey()), "%" + criteria.getValue().toString() + "%"
                );
            }else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}
