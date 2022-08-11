package com.emit.vehicle.repository.specification;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BrandSpecification implements Specification<Brand> {

    private final SearchCriteria criteria;

    public BrandSpecification(SearchCriteria searchCriteria){
        this.criteria = searchCriteria;
    }

    @Override
    public Specification<Brand> and(Specification<Brand> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Brand> or(Specification<Brand> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().equalsIgnoreCase(OperationParameter.GREATER_THAN.getValue())){
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString()
            );
        } else if(criteria.getOperation().equalsIgnoreCase(OperationParameter.LOWER_THAN.getValue())   ){
            return criteriaBuilder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString()
            );
        } else if(criteria.getOperation().equalsIgnoreCase(OperationParameter.EQUALS_TO.getValue())){
            if(root.get(criteria.getKey()).getJavaType() == String.class){
                return criteriaBuilder.like(
                        root.<String> get(criteria.getKey()), "%" + criteria.getValue() + "%"
                );
            } else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}
