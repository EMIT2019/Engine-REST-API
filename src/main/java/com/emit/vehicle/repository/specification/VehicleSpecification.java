package com.emit.vehicle.repository.specification;

import com.emit.vehicle.model.Brand;
import com.emit.vehicle.model.Type;
import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.repository.specification.parameters.BrandParameter;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import com.emit.vehicle.repository.specification.parameters.TypeParameter;
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
                Join<Brand, Vehicle> brandVehiclesJoin = root.join(criteria.getKey());
                return criteriaBuilder.like(
                        brandVehiclesJoin.get(BrandParameter.BRAND_NAME_FIELD.getValue()), "%" + criteria.getValue() + "%"
                );
            } else if(root.get(criteria.getKey()).getJavaType() == Type.class){
                Join<Type, Vehicle> typeVehicleJoin = root.join(criteria.getKey());
                return criteriaBuilder.like(
                        typeVehicleJoin.get(TypeParameter.TYPE_NAME_FIELD.getValue()), "%" +  criteria.getValue() + "%"
                );
            } else if(root.get(criteria.getKey()).getJavaType() == String.class){
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
