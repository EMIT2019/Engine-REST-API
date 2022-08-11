package com.emit.vehicle.repository.specification;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.repository.specification.parameters.BrandParameter;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class VehicleSpecification implements Specification<Vehicle> {
    private final SearchCriteria criteria;

    public VehicleSpecification(SearchCriteria searchCriteria){
        this.criteria = searchCriteria;
    }

    @Override
    public Specification<Vehicle> and(Specification<Vehicle> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Vehicle> or(Specification<Vehicle> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().equalsIgnoreCase(OperationParameter.GREATER_THAN.getValue())){
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString()
            );
        } else if(criteria.getOperation().equalsIgnoreCase(OperationParameter.LOWER_THAN.getValue())){
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString()
            );
        } else if(criteria.getOperation().equalsIgnoreCase(OperationParameter.EQUALS_TO.getValue())) {
            if(root.get(criteria.getKey()).getJavaType() == Brand.class){
                Join<Brand, Vehicle> brandVehicles = root.join(criteria.getKey());
                return criteriaBuilder.like(
                        brandVehicles.get(BrandParameter.BRAND_NAME_FIELD.getValue()), "%" + criteria.getValue() + "%"
                );
            }
        }
        return null;
    }
}
