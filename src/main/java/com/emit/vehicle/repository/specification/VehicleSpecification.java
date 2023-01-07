package com.emit.vehicle.repository.specification;

import antlr.StringUtils;
import com.emit.vehicle.model.Brand;
import com.emit.vehicle.model.Type;
import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.repository.specification.parameters.BrandParameter;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import com.emit.vehicle.repository.specification.parameters.TypeParameter;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.*;
import java.util.Objects;

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
        //Search a vehicle when an speed information is provided from the client
        if(criteria.getOperation() == OperationParameter.GREATER_THAN){
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString()
            );
            
        } else if(criteria.getOperation() == OperationParameter.LOWER_THAN){
            return criteriaBuilder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString()
            );
        } else if(criteria.getOperation() == OperationParameter.EQUALS_TO) {
            if(root.get(criteria.getKey()).getJavaType() == Brand.class){
                Join<Brand, Vehicle> brandVehiclesJoin = root.join(criteria.getKey());

                if(isNumeric((String) criteria.getValue())){
                    return criteriaBuilder.equal(
                            brandVehiclesJoin.get(BrandParameter.BRAND_ID_FIELD.getValue()), criteria.getValue()
                    );
                } else {
                    return criteriaBuilder.like(
                            brandVehiclesJoin.get(BrandParameter.BRAND_NAME_FIELD.getValue()), "%" + criteria.getValue() + "%"
                    );
                }

            } else if(root.get(criteria.getKey()).getJavaType() == Type.class){
                Join<Type, Vehicle> typeVehicleJoin = root.join(criteria.getKey());

                if(isNumeric((String) criteria.getValue())){
                    return criteriaBuilder.equal(
                            typeVehicleJoin.get(TypeParameter.TYPE_ID_FIELD.getValue()), criteria.getValue()
                    );
                } else {
                    return criteriaBuilder.like(
                            typeVehicleJoin.get(TypeParameter.TYPE_NAME_FIELD.getValue()), "%" + criteria.getValue() + "%"
                    );
                }

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

    //Method to check if a criteria object is an instance of Integer or String
    public static boolean isNumeric(String value) {
        if(value == null){
            return false;
        }

        try {
            int number = Integer.parseInt(value);

        }catch(NumberFormatException e){
            return false;
        }

        return true;
    }
}
