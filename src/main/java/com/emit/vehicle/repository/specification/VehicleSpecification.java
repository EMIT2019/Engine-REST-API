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

        try{
            switch (criteria.getOperation()){
                //Search a vehicle when a speed information is provided from the client
                case GREATER_THAN:
                    return criteriaBuilder.greaterThanOrEqualTo(
                            root.<String> get(criteria.getKey()), criteria.getValue().toString()
                    );
                //Search a vehicle when a speed information is provided from the client
                case LOWER_THAN:
                    return criteriaBuilder.lessThanOrEqualTo(
                            root.<String> get(criteria.getKey()), criteria.getValue().toString()
                    );
                //Search a vehicle when any kind of information is provided from the client
                case EQUALS_TO:
                    if(root.get(criteria.getKey()).getJavaType() == Brand.class){
                        //Making a join from vehicle table to brand table for making a search based on a brand data provided for the client
                        Join<Brand, Vehicle> brandVehiclesJoin = root.join(criteria.getKey());

                        //Based on the information provided, here it makes a search based on the selected primary key value or a typed data for the client
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
                        //Making a join from vehicle table to type table for making a search based on a brand data provided for the client
                        Join<Type, Vehicle> typeVehicleJoin = root.join(criteria.getKey());

                        //Based on the information provided, here it makes a search based on the selected primary key value or a typed data for the client
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
                default:
                    System.out.println("Something went wrong!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //Method to check if a criteria object is an instance of Integer or String
    // (This method allows the client to make a search by typing a descriptive parameter or simply using a preload catalog)
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
