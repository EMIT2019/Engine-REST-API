package com.emit.vehicle.repository.specification.builders;

import com.emit.vehicle.model.Vehicle;
import com.emit.vehicle.repository.specification.SearchCriteria;
import com.emit.vehicle.repository.specification.VehicleSpecification;
import com.emit.vehicle.repository.specification.parameters.OperationParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class VehicleSpecificationBuilder {
    private final List<SearchCriteria> params;

    public VehicleSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public final VehicleSpecificationBuilder with(final String key, final String operation, final Object value){
        return with(null, key, operation, value, null, null);
    }

    public final VehicleSpecificationBuilder with(final String orPredicate, final String key, final String operation, final Object value, final @Nullable String prefix, final @Nullable String suffix){
        OperationParameter op = OperationParameter.getValueByInput(operation.charAt(0));

         if(op != null){
            if(op == OperationParameter.EQUALS_TO){
                boolean startsWithAsterisk = prefix != null && prefix.contains(OperationParameter.ZERO_OR_MORE_REGEX);
                boolean endsWithAsterisk = suffix != null && suffix.contains(OperationParameter.ZERO_OR_MORE_REGEX);

                if(startsWithAsterisk && endsWithAsterisk){
                    op = OperationParameter.CONTAINS;
                } else if(startsWithAsterisk){
                    op = OperationParameter.ENDS_WITH;
                } else if(endsWithAsterisk){
                    op = OperationParameter.STARTS_WITH;
                }
            }
            params.add(
              new SearchCriteria(orPredicate, key, op, value)
            );
         }
        return this;
    }

    public Specification build(){
        if(params.size() == 0) return null;

        Specification<Vehicle> result = new VehicleSpecification(params.get(0));

        for(int i = 1; i < params.size(); i++){
            result = params.get(i).isOrPredicate() ? Specification.where(result).or(new VehicleSpecification(params.get(i))) : Specification.where(result).and(new VehicleSpecification(params.get(i)));
        }

        return result;
    }
}
